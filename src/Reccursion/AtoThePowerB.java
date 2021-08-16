package Reccursion;

public class AtoThePowerB {
    static int step = 0;
    static int stepFast = 0;

    public static void main(String[] args) {

        System.out.println(fastPow(2, 50));
        System.out.println("optimized steps count: " + stepFast);

        System.out.println();

        System.out.println(pow(2, 50));
        System.out.println("unoptimized steps count: " + step);
    }

    static long fastPow(long a, long b) {
        stepFast++;
        if (b == 0) return 1;
        else if(b%2 == 0) return fastPow(a*a,b/2);
        else return a * fastPow(a,b-1);
    }


    static long pow(long a, long b){
        step++;
        if(b==0) return 1;
        return a * pow(a, b-1);
    }

}
