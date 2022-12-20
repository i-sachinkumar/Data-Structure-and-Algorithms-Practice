package Mission450;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.*;
import java.util.*;

public class Readers {
    static boolean multipleTC = false, memory = false;
    FastReader in;
    PrintWriter out;

    public static void main(String[] args) throws Exception {
        if (memory) new Thread(null, new Runnable() {
            public void run() {
                try {
                    new Readers().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 28).start();
        else new Readers().run();
    }

    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        for (int i = 1, T = (multipleTC) ? ni() : 1; i <= T; i++) solve(i);
        out.flush();
        out.close();
    }

    void solve(int TC) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().trim().split(" ");
        int p = Integer.parseInt(line[0]), s = Integer.parseInt(line[1]);
        //int[][] ns = new int[s][2];
        int[][] n_i = new int[p][2];
        for(int i = 0 ; i < p ; i++){
            int[][] ns = new int[s][2];
            String[] line1 = br.readLine().trim().split(" ");
            String[] line2 = br.readLine().trim().split(" ");
            for(int j = 0 ; j < s ; j++) ns[j][0] = Integer.parseInt(line1[j]);
            for(int j = 0 ; j < s ; j++) ns[j][1] = Integer.parseInt(line2[j]);
            Arrays.sort(ns, Comparator.comparingInt(o -> o[0]));
            for(int j = 0 ; j < s-1; j++){
                if(ns[j][1] > ns[j+1][1]) n_i[i][0]++;
            }
            n_i[i][1] = i+1;
        }
        Arrays.sort(n_i, Comparator.comparingInt(o -> o[0]));
        for(int[] in : n_i){
            pw.println(in[1]);
        }
        br.close();
        pw.close();
    }

    long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }

    void p(Object o) {
        out.print(o);
    }

    void pn(Object o) {
        out.println(o);
    }

    void pni(Object o) {
        out.println(o);
        out.flush();
    }

    String n() {
        return in.next();
    }

    String nln() {
        return in.nextLine();
    }

    int ni() {
        return Integer.parseInt(in.next());
    }

    long nl() {
        return Long.parseLong(in.next());
    }

    double nd() {
        return Double.parseDouble(in.next());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception {
            br = new BufferedReader(new FileReader(s));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
