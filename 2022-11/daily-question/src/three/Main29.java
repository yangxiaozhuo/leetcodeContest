package three;

/**
 * 813. 最大平均值和的分组
 *
 * @author yangxiaozhuo
 * @date 2022/11/28
 */
public class Main29 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6,7};
        Solution solution = new Solution();
        System.out.println(solution.largestSumOfAverages(ints, 4));
    }
    static class Solution {
        public double largestSumOfAverages(int[] nums, int k) {
            double[][] dp = new double[nums.length][k + 1];
            double[] preSum = new double[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] = preSum[i] + nums[i]; //presum[i] = num[0] +++num[i - 1]
                dp[i][1] = preSum[i + 1] / (i + 1);
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = 2; j <= k; j++) {
                    for (int l = 0; l < i; l++) {
                        dp[i][j] = Math.max(dp[i][j], dp[l][j - 1] + (preSum[i+1] - preSum[l+1]) / (i - l));
                    }
                }
            }
            return dp[nums.length - 1][k];
        }
    }

    static class Solution2 {
        double max = 0;

        public double largestSumOfAverages(int[] nums, int k) {
            max = 0;
            dfs(nums, k, 0, 0, 0);
            return max;
        }

        //index 是组 have是序号
        private void dfs(int[] nums, int k, int index, int have, double res) {
            if (have == nums.length) {
                if (index == k) {
                    max = Math.max(max, res);
                }
                return;
            }
            if (index > k) {
                return;
            }
            double temp = 0;
            for (int i = have; i < nums.length; i++) {
                temp = temp + nums[i];
                dfs(nums, k, index + 1, i + 1, res + temp / (i - have + 1));
            }
        }
    }
}
