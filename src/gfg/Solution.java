package gfg;

import java.util.*;

class Solution {
    public static void main(String[] args) {

    }

    //KickStart 2022 round F
    public static void waterTank() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int num = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            for (int i = 0; i < n - 1; i++) {
                sc.nextInt();
                sc.nextInt();
            }
            for (int i = 0; i < q; i++) {
                sc.nextInt();
            }
            int count = 0;
            int i = 1;
            for (; count <= n; i = i * 2) {
                if (q >= i) {
                    count += i;
                    q -= i;
                } else break;
            }

            i = n - count;
            if (q >= i) count += i;

            System.out.println("Case #" + num + ": " + count);
            num++;
        }
    }

    //KickStart 2022 round F
    static class Fabric {
        public String color;
        public int dur;
        public int id;

        public Fabric(String color, int dur, int id) {
            this.color = color;
            this.dur = dur;
            this.id = id;
        }

        public String getColor() {
            return color;
        }

        public int getDur() {
            return dur;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Fabric{" +
                    "color='" + color + '\'' +
                    ", dur=" + dur +
                    ", id=" + id +
                    '}';
        }
    }

    //KickStart 2022 round F
    public static void fabric() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Fabric> colorSorted = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String c = sc.next();
                int d = sc.nextInt();
                int idn = sc.nextInt();
                sc.nextLine();
                colorSorted.add(new Fabric(c, d, idn));
            }

            ArrayList<Fabric> durSorted = new ArrayList<>(colorSorted);
            colorSorted.sort(Comparator.comparing((Fabric::getColor))
                    .thenComparingInt(Fabric::getId));
            durSorted.sort(Comparator.comparing((Fabric::getDur))
                    .thenComparingInt(Fabric::getId));
            System.out.println(durSorted);
            System.out.println(colorSorted);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (colorSorted.get(i).id == durSorted.get(i).id) count++;
            }
            System.out.println(count);
        }
    }
}