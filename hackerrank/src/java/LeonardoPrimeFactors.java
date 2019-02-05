package java;

/**
 * Created by gouthamvidyapradhan on 12/05/2018.
 *
 * https://www.hackerrank.com/challenges/leonardo-and-prime/problem
 */
public class LeonardoPrimeFactors {
    private static int[] primes = new int[15];

    public static void main(String[] args) {
        long n = (long)1e18;
        System.out.println(primeCount(n));
    }

    static int primeCount(long n) {
        calculateFirst15Primes();
        long result = 1;
        int count = 0;
        for(int i = 0; i < primes.length; i ++){
            result *= primes[i];
            if(result <= n){
                count++;
            } else break;
        }
        return count;
    }

    private static void calculateFirst15Primes(){
        for(int i = 2, j = 0; j < 15; i ++){
            if(isPrime(i)){
                primes[j++] = i;
            }
        }
    }

    private static boolean isPrime(int n){
        int sqRt = (int)Math.sqrt(n);
        for(int i = 2; i <= sqRt; i ++){
            if((n % i) == 0){
                return false;
            }
        }
        return true;
    }
}
