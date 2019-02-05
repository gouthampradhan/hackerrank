package java;

/**
 * Created by gouthamvidyapradhan on 12/05/2018.
 *
 * https://www.hackerrank.com/challenges/find-point/problem
 */
public class FindPoint {
    public static void main(String[] args) {

    }

    static int[] findPoint(int px, int py, int qx, int qy) {
        int[] R = new int[2];
        int nx = (px == qx) ? px : (px < qx) ? qx + (qx - px) : qx - (px - qx);
        int ny = (py == qy) ? py : (py < qy) ? qy + (qy - py) : qy - (py - qy);
        R[0] = nx;
        R[1] = ny;
        return R;
    }
}
