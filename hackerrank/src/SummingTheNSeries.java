/**
 * Created by gouthamvidyapradhan on 12/05/2018.
 *
 * https://www.hackerrank.com/challenges/summing-the-n-series/problem
 */
public class SummingTheNSeries {
    public static void main(String[] args) {
    }

    static int summingSeries(long n) {
        return (int)(((((n % 1000000007) % 1000000007) * (n % 1000000007))) % 1000000007);
    }
}
