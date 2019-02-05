package java;

/**
 * Created by gouthamvidyapradhan on 13/05/2018.
 * https://www.hackerrank.com/challenges/diwali-lights/problem
 */
public class DiwaliLights {
    private static final int MOD = (int)1e5;

    public static void main(String[] args) {
        System.out.println(lights(2));
    }

    static long lights(int n) {
        long result = pow(2, n);
        if(result - 1 < 0){
            return (long)(1e5 - 1);
        } else return result - 1;
    }

    private static long pow(long n, long p){
        if(p == 1) return n;
        if(p == 0) return 1;
        else{
            if((p % 2) == 0){
                long f1 = pow(n, p / 2) % MOD;
                return ((f1 * f1) % MOD);
            } else{
                long f1 = pow(n, p / 2) % MOD;
                return (((f1 * f1) % MOD) * n) % MOD;
            }
        }
    }
}
