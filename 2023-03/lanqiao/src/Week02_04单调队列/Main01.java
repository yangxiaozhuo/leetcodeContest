package Week02_04单调队列;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        long m = Long.parseLong(s[1]);
        s = in.readLine().split(" ");
        int[] nums = new int[n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
            sum[i] = sum[i - 1] + nums[i];
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = fun(dp, nums, i, m);
        }
        out.println(dp[n]);
        out.flush();
    }

    private static int fun(int[] dp, int[] nums, int at, long m) {
        int res = dp[at - 1] + nums[at];
        int sum = nums[at];
        int max = nums[at];
        for (int i = at - 1; i >= 1; i--) {
            if (sum + nums[i] > m) {
                return res;
            }
            sum += nums[i];
            max = Math.max(max, nums[i]);
            res = Math.min(res, dp[i - 1] + max);
        }
        return res;
    }
}
