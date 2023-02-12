package other;

import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/02/02
 */
public class Main413 {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int res = 0;
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 2);
            for (int i = 2; i < dp.length; i++) {
                if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                }
                if (dp[i] > 3) {
                    res = res + dp[i] - 2;
                }
            }
            return res;
        }
    }
}
