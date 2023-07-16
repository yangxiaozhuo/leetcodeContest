package test08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author yangxiaozhuo
 * @date 2023/05/07
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int t = Integer.parseInt(s[1]);
            String[] s1 = in.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s1[i]);
            }
            System.out.println(fun(nums, t));
        }
    }

    private static long fun(int[] nums, int t) {
        int mod = 1000000007;
        long[] dp = new long[64];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < 64; j++) {
                dp[j & num] = dp[j & num] + dp[j];
                dp[j & num] = dp[j & num] % mod;
            }
            dp[num]++;
        }
        long res = 0;
        for (int i = 0; i < 64; i++) {
            if (is(i, t)) {
                res += dp[i];
                res = res % mod;
            }
        }
        return res;
    }

    private static boolean is(int i, int res) {
        int t = 0;
        while (i != 0) {
            t = t + (i & 1);
            i= i>>1;
        }
        return t == res;
    }
}
