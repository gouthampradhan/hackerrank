/**
 * Created by gouthamvidyapradhan on 12/05/2018.
 */
public class SherlockAndPermutations {
    private static final int MOD = (int)1e9+7;

    public static void main(String[] args) {
        System.out.println(solve(1, 1));
    }

    static int solve(int n, int m) {
        //n number of 0's
        //m number of 1's
        m -= 1;
        /*
        (n + m)! / (n! * m!)
         */
        long numerator = fact(n + m);
        return (int)(((((pow(fact(n), MOD - 2) % MOD) * (pow(fact(m), MOD - 2) % MOD)) % MOD) * numerator) % MOD);
    }

    private static long fact(long n){
        if(n == 0) return 1;
        long result = n;
        while(n > 1){
            result = (((result % MOD) * (--n % MOD))) % MOD;
        }
        return result;
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
