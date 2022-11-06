//2441. 与对应负数同时存在的最大正整数

import java.util.Arrays;

/**
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 2, -3, 3};
        System.out.println(solution.findMaxK(nums));
    }

    static class Solution {
        public int findMaxK(int[] nums) {
            Arrays.sort(nums);
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == 0) {
                    return nums[r];
                } else if (nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
            return -1;
        }
    }
}

