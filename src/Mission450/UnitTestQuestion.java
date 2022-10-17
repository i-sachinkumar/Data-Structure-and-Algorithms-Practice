package Mission450;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UnitTestQuestion {
    public static class TestHarness {
        int pathToBeChecked = 13;
        boolean[] pathsTaken = new boolean[13];

        public void setPathToBeChecked(int path) {
            pathToBeChecked = path;
        }

        public void notePathTaken(int location) {
            pathsTaken[location] = true;
        }

        public void writeOutputs() {
            System.out.println("Path + pathToBeChecked" + "taken: "
                    + pathsTaken[pathToBeChecked - 1]);
        }
    }

    public static interface TimeManager {
        public enum DayOfWeek {
            SUN,
            MON,
            TUE,
            WED,
            THR,
            FRI,
            SAT
        }
        public DayOfWeek getCurrentDay();
    }

    public static interface AccountDataStore {
        public enum Type {
            NORMAL,
            ZERO_CHARGES
        }

        public boolean isAccountPresent(String accountid);

        public void createAccount(String accountid, Type t);

        public int getBalance(String accountid);

        public Type getType(String accountid);

        public void setBalance(String accountid, int newBalance);
    }

    public static class ATMException extends Exception {
        private static final long serialVersionUID =
                3872234239300357354L;

        public ATMException() {
        }

        public ATMException(String msg) {
            super(msg);
        }
    }

    public static class TimeManagerImpl implements TimeManager {
        @Override
        public DayOfWeek getCurrentDay() {
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            return TimeManager.DayOfWeek.values()[day - 1];
        }
    }

    public static class AccountDataStoreImpl implements AccountDataStore {
        Map<String, Type> accountType = new HashMap<>();
        Map<String, Integer> accountBal = new HashMap<>();

        @Override
        public boolean isAccountPresent(String accountid) {
            return accountType.containsKey(accountid);
        }

        @Override
        public void createAccount(String accountid, Type t) {
            accountType.put(accountid, t);
            accountBal.put(accountid, 0);
        }

        @Override
        public int getBalance(String accountid) {
            return accountBal.get(accountid);
        }

        @Override
        public Type getType(String accountid) {
            return accountType.get(accountid);
        }

        @Override
        public void setBalance(String accountid, int newBalance) {
            accountBal.put(accountid, newBalance);
        }
    }

    public static class ATM {
        TestHarness th = new TestHarness();
        TimeManager tm = new TimeManagerImpl();
        AccountDataStore ads = new AccountDataStoreImpl();

        public void createNormalAccount(String accountid, int balance)
                throws ATMException {
            if (ads.isAccountPresent(accountid)) {
                th.notePathTaken(0);
                throw new ATMException("Account already exists");
            }
            ads.createAccount(accountid, AccountDataStore.Type.NORMAL);
            ads.setBalance(accountid, balance);
            th.notePathTaken(1);
        }

        public void createZeroChargesAccount(String accountid, int
                balance) throws ATMException {
            if (ads.isAccountPresent(accountid)) {
                th.notePathTaken(2);
                throw new ATMException("Account already exists");
            }
            ads.createAccount(accountid,
                    AccountDataStore.Type.ZERO_CHARGES);
            ads.setBalance(accountid, balance);
            th.notePathTaken(3);
        }

        public int getBalance(String accountid) throws ATMException {
            if (!ads.isAccountPresent(accountid)) {
                th.notePathTaken(4);
                throw new ATMException("Account does not exist");
            }
            th.notePathTaken(5);
            return ads.getBalance(accountid);
        }

        public void withdraw(String accountid, int amount) throws
                ATMException {
            if (!ads.isAccountPresent(accountid)) {
                th.notePathTaken(6);
                throw new ATMException("Account does not exist");
            }
            if (amount < 1000) {
                th.notePathTaken(7);
                throw new ATMException("Minimum withdrawal is 1000");
            }
            if (amount > 40000) {
                th.notePathTaken(8);
                throw new ATMException("Maximum withdrawal is 40,000");
            }

            if (amount % 100 != 0) {
                th.notePathTaken(9);
                throw new ATMException("Withdrawal only allowed in multiples of 100");
            }
            TimeManager.DayOfWeek day = tm.getCurrentDay();
            if (day == TimeManager.DayOfWeek.SUN || day ==
                    TimeManager.DayOfWeek.SAT) {
                th.notePathTaken(10);
                throw new ATMException("Withdrawal only allowed on weekdays");
            }
            int charges = 0;
            AccountDataStore.Type accountType = ads.getType(accountid);
            if (accountType == AccountDataStore.Type.NORMAL) charges = amount / 20;
            int totalToDeduct = charges + amount;
            int balance = ads.getBalance(accountid);
            if (balance < totalToDeduct) {
                th.notePathTaken(11);
                throw new ATMException("Insufficient balance");
            }
            th.notePathTaken(12);
            ads.setBalance(accountid, balance - totalToDeduct);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        ATM atm = new ATM();
        atm.th.setPathToBeChecked(p);
        atm.th.writeOutputs();
    }

}

