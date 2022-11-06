package three;

import java.util.Arrays;

/**
 * 1235. 规划兼职工作
 *
 * @author yangxiaozhuo
 * @date 2022/10/22
 */
public class Main22 {
    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int[][] nums = new int[startTime.length][3];
            for (int i = 0; i < startTime.length; i++) {
                nums[i][0] = startTime[i];
                nums[i][1] = endTime[i];
                nums[i][2] = profit[i];
            }
            Arrays.sort(nums, (o1, o2) -> o1[1] - o2[1]);
            int[] dp = new int[nums.length + 1];
            for (int i = 1; i < dp.length; i++) {
                int index = find(nums[i - 1][0], i - 1, nums);
                dp[i] = Math.max(dp[i - 1], dp[index] + nums[i - 1][2]);
            }
            return dp[dp.length - 1];
        }

        public int find(int startTime, int right, int[][] nums) {
            int l = 0;
            while (l < right) {
                int mid = l + right >> 1;
                if (nums[mid][1] > startTime) {
                    right = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}
