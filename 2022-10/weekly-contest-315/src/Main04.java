//2444. 统计定界子数组的数目

/**
 * 给你一个整数数组 nums 和两个整数 minK 以及 maxK 。
 * nums 的定界子数组是满足下述条件的一个子数组：
 * 子数组中的 最小值 等于 minK 。
 * 子数组中的 最大值 等于 maxK 。
 * 返回定界子数组的数目。
 * 子数组是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,5,2,7,5], minK = 1, maxK = 5
 * 输出：2
 * 解释：定界子数组是 [1,3,5] 和 [1,3,5,2] 。
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 5, 2, 7, 5};
        System.out.println(solution.countSubarrays(nums, 1, 5));
    }

    static class Solution {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            long ans = 0;
            int minindex = -1;
            int maxindex = -1;
            int overIndex = -1;
            int left = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == minK) {
                    minindex = i;
                }
                if (nums[i] == maxK) {
                    maxindex = i;
                }
                if (nums[i] > maxK || nums[i] < minK) {
                    overIndex = i;
                }
                left = Math.min(maxindex, minindex);
                ans += Math.max(left - overIndex, 0);
            }
            return ans;
        }
    }
}
