package one;

/**
 * 801. 使序列递增的最小交换次数
 *
 * @author yangxiaozhuo
 * @date 2022/10/10
 */
public class Main10 {
    class Solution {
        public int minSwap(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length][2];  //dp[][0] 不交换 dp[][1]交换
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = dp.length;
                dp[i][1] = dp.length;
            }
            dp[0][0] = 0; //不交换下标为0的元素
            dp[0][1] = 1; //交换下标为0的元素，次数加1
            for (int i = 1; i < nums1.length; i++) {
                if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                }
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
                }
            }
            return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
        }
    }
}
