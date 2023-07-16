package test03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/07/08
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] t = {{0, 0}, {1, 1}, {0, 2}};
        System.out.println(Arrays.toString(solution.countBlackBlocks(3, 3, t)));
    }
}

class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        long[] res = new long[5];
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < coordinates.length; i++) {
            int a = coordinates[i][0];
            int b = coordinates[i][1];
            int num = fun(set, a, b, m, n);
            if (num != -1) {
                res[num]--;
                res[num + 1]++;
            }

            num = fun(set, a - 1, b, m, n);
            if (num != -1) {
                res[num]--;
                res[num + 1]++;
            }

            num = fun(set, a, b - 1, m, n);
            if (num != -1) {
                res[num]--;
                res[num + 1]++;
            }

            num = fun(set, a - 1, b - 1, m, n);
            if (num != -1) {
                res[num]--;
                res[num + 1]++;
            }
            long t = 100001L * a + b;
            set.add(t);
        }
        long temp = ((long) m - 1) * (n - 1);
        res[0] = temp - res[1] - res[2] - res[3] - res[4];
        return res;
    }

    private int fun(HashSet<Long> set, int a, int b, int m, int n) {
        if (a < 0 || b < 0 || a >= m - 1 || b >= n - 1) {
            return -1;
        }
        int res = 0;
        long t;
        t = 100001L * a + b;
        if (set.contains(t)) {
            res++;
        }
        t = 100001L * a + (b + 1);
        if (set.contains(t)) {
            res++;
        }
        t = 100001L * (a + 1) + b;
        if (set.contains(t)) {
            res++;
        }
        t = 100001L * (a + 1) + (b + 1);
        if (set.contains(t)) {
            res++;
        }
        return res;
    }
}