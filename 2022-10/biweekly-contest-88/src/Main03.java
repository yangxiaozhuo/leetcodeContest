/**
 * 2425. 所有数对的异或和
 *
 * @author yangxiaozhuo
 * @date 2022/10/01
 * <p>
 * 给你两个下标从 0开始的数组nums1 和nums2，两个数组都只包含非负整数。请你求出另外一个数组nums3，包含 nums1和 nums2中 所有数对的异或和（nums1中每个整数都跟 nums2中每个整数 恰好匹配一次）。
 * 请你返回 nums3中所有整数的 异或和。
 * <p>
 * 示例 1：
 * 输入：nums1 = [2,1,3], nums2 = [10,2,5,0]
 * 输出：13
 * 解释：
 * 一个可能的 nums3 数组是 [8,0,7,2,11,3,4,1,9,1,6,3] 。
 * 所有这些数字的异或和是 13 ，所以我们返回 13 。
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{2, 1, 3};
        int[] nums2 = new int[]{10, 2, 5, 0};
        System.out.println(solution.xorAllNums(nums1, nums2));
    }

    static class Solution {
        public int xorAllNums(int[] nums1, int[] nums2) {
            int a = nums1.length % 2;
            int b = nums2.length % 2;
            int res = 0;
            if (b == 1) {
                for (int j : nums1) {
                    res ^= j;
                }
            }
            if (a == 1) {
                for (int j : nums2) {
                    res ^= j;
                }
            }
            return res;
        }
    }
}
