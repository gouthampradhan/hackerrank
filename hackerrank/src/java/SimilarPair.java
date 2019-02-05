package java; /**
 * Created by gouthamvidyapradhan on 28/05/2018.
 *
 * https://www.hackerrank.com/challenges/similarpair/problem
 */
import java.util.*;

public class SimilarPair {
    static class Ftree{
        private int[] a;
        Ftree(int n){
            a = new int[n + 1];
        }

        void update(int p, int v){
            for(int i = p + 1; i < a.length; i += (i & (-i))){
                a[i] += v;
            }
        }

        long getRangeSum(int p){
            long sum = 0L;
            for(int i = p + 1; i > 0; i -= (i & (-i))){
                sum += a[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 7}, {1, 10}, {10, 15}, {15, 4},
        {15, 16},
         {16,
        18}, {16,
        17}, {17,
        2}, {10,
         5},
                {5, 3}, {3, 19}, {1, 9}, {9, 11}, {11, 13}, {11, 12}, {12, 8}, {12, 20}, {11, 14}, {1, 6}};
        System.out.println(similarPair(20, 5, edges));
    }

    /*
     * Complete the similarPair function below.
     */
    private static List[] graph = new List[100005];
    private static Stack<Integer> stack = new Stack<>();
    private static BitSet done = new BitSet();
    private static long ans ;
    @SuppressWarnings("unchecked")
    static long similarPair(int n, int k, int[][] edges) {
        if(edges.length == 0 || n == 1) return 0;
        Ftree ft = new Ftree(n);
        ans = 0;
        for(int i = 0; i <= n; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
        }
        for(int i = 1; i <= n; i ++){
            if(!done.get(i)){
                dfs(i, stack, done);
            }
        }
        int root = stack.pop();
        done.clear();
        dfs(root, ft, done, k, n);
        return ans;
    }

    @SuppressWarnings("unchecked")
    private static void dfs(int u, Stack<Integer> toposort, BitSet done){
        done.set(u);
        List<Integer> children = graph[u];
        if(children != null){
            for(int c : children){
                if(!done.get(c)){
                    dfs(c, toposort, done);
                }
            }
        }
        toposort.push(u);
    }
    @SuppressWarnings("unchecked")
    private static void dfs(int u, Ftree ft, BitSet done, int k, int n){
        done.set(u);
        ft.update(u - 1, 1);
        List<Integer> children = graph[u];
        if(children != null){
            for(int c : children){
                if(!done.get(c)){
                    dfs(c, ft, done, k, n);
                }
            }
        }
        int e = (u + k) > n ? n - 1 : (u + k - 1);
        if(u - k - 1 <= 0){
            ans += ft.getRangeSum(e);
        } else {
            int s = (u - k - 2);
            ans += (ft.getRangeSum(e) - ft.getRangeSum(s));
        }
        ans -= 1;
        ft.update(u - 1, -1);
    }
}
