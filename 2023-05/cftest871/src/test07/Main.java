package test07;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @author yangxiaozhuo
 * @date 2023/05/06
 */
public class Main {
    static long[][] dp = new long[2000][2000];

    static {
        for (int i = 1; i < 2000; i++) {
            for (int j = 1; j <= i; j++) {
                long t = (i - 1) * i / 2 + j;
                dp[i][j] = t * t;
            }
        }
        for (int i = 1; i < 2000; i++) {
            for (int j = 1; j < 2000; j++) {
                dp[j][i] = dp[j - 1][i] + dp[j][i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(in.readLine());
            out.println(fun(n));
        }
        out.flush();
    }

    private static long fun(int n) {
        long res = 0;
        int[] nums = find(n);
        int i = nums[0];
        int j = nums[1];
        for (int k = 0; k < j; k++) {
            res = res + dp[i - k][j - k];
        }
        return res;
    }

    private static long cul(int[] vis, int i, int j) {
        if (i < 1 || j < 1 || j > i) {
            return 0;
        }
        int t = (i - 1) * i / 2 + j;
        if (vis[t] == 1) {
            return 0;
        }
        vis[t] = 1;
        return t * (long) t + cul(vis, i - 1, j) + cul(vis, i - 1, j - 1);
    }

    private static int[] find(int n) {
        int l = 0;
        int r = 2023;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if ((mid + 1) * mid / 2 >= n) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return new int[]{l + 1, n - (l + 1) * l / 2};
    }
}
