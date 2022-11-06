//2449. 使数组相似的最少操作次数

import java.util.Arrays;

/**
 * 给你两个正整数数组nums 和target，两个数组长度相等。
 * 在一次操作中，你可以选择两个 不同的下标i 和j，其中0 <= i, j < nums.length，并且：
 * 令nums[i] = nums[i] + 2且
 * 令nums[j] = nums[j] - 2。
 * 如果两个数组中每个元素出现的频率相等，我们称两个数组是 相似的。
 * 请你返回将 nums变得与 target相似的最少操作次数。测试数据保证 nums一定能变得与 target相似。
 * <p>
 * 示例 1：
 * 输入：nums = [8,12,6], target = [2,14,10]
 * 输出：2
 * 解释：可以用两步操作将 nums 变得与 target 相似：
 * - 选择 i = 0 和 j = 2 ，nums = [10,12,4] 。
 * - 选择 i = 1 和 j = 2 ，nums = [10,14,2] 。
 * 2 次操作是最少需要的操作次数。
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{8, 12, 6};
        int[] target = new int[]{2, 14, 10};
        System.out.println(solution.makeSimilar(nums, target));
    }

    static class Solution {
        public long makeSimilar(int[] nums, int[] target) {
            int[] numsSort = sort(nums);
            int[] targetSort = sort(target);
            Arrays.sort(numsSort, 1, numsSort[0]);
            if (targetSort[0] < targetSort.length) {
                Arrays.sort(numsSort, numsSort[0], numsSort.length);
            }
            Arrays.sort(targetSort, 1, targetSort[0]);
            if (targetSort[0] < targetSort.length) {
                Arrays.sort(targetSort, targetSort[0], targetSort.length);
            }
            long res = 0;
            for (int i = 1; i < targetSort.length; i++) {
                res += Math.abs(targetSort[i] - numsSort[i]);
            }
            return res / 4;
        }

        private int[] sort(int[] nums) {
            int[] res = new int[nums.length + 1];
            int index = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0) {
                    res[index] = nums[i];
                    index++;
                }
            }
            res[0] = index;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 1) {
                    res[index] = nums[i];
                    index++;
                }
            }
            return res;
        }
    }
}
