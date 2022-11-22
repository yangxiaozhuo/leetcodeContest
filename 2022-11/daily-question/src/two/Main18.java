package two;

import java.util.Arrays;

/**
 * 891. 子序列宽度之和
 *
 * @author yangxiaozhuo
 * @date 2022/11/18
 */
public class Main18 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 1, 3};
        System.out.println(solution.sumSubseqWidths(nums));
    }

    static class Solution {
        static int mod = 1000000007;
        static long[] dp = new long[100010];

        static {
            dp[0] = 1;
            for (int i = 1; i < dp.length; i++) {
                dp[i] = (dp[i - 1] * 2) % mod;
            }
        }

        public int sumSubseqWidths(int[] nums) {
            long res = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                res = (res + (dp[i] - dp[nums.length - i - 1]) * nums[i]) % mod;
            }
            return (int) res % mod;
        }
    }
}
