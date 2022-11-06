/**
 * 2439. 最小化数组中的最大值
 *
 * @author yangxiaozhuo
 * @date 2022/10/15
 * 给你一个下标从 0开始的数组nums，它含有n个非负整数。
 * 每一步操作中，你需要：
 * 选择一个满足1 <= i < n的整数 i，且nums[i] > 0。
 * 将nums[i]减 1 。
 * 将nums[i - 1]加 1 。
 * 你可以对数组执行 任意次上述操作，请你返回可以得到的 nums数组中最大值最小 为多少。
 * <p>
 * 示例 1：
 * 输入：nums = [3,7,1,6]
 * 输出：5
 * 解释：
 * 一串最优操作是：
 * 1. 选择 i = 1 ，nums 变为 [4,6,1,6] 。
 * 2. 选择 i = 3 ，nums 变为 [4,6,2,5] 。
 * 3. 选择 i = 1 ，nums 变为 [5,5,2,5] 。
 * nums 中最大值为 5 。无法得到比 5 更小的最大值。
 * 所以我们返回 5 。
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 7, 1, 6};
        System.out.println(solution.minimizeArrayValue(nums));
    }

    static class Solution {
        public int minimizeArrayValue(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            int l = nums[0];
            int r = max;
            while (l < r) {
                int mid = l + r >> 1;
                if (fun(mid, nums)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        public boolean fun(int mid, int[] arr) {
            long sum = 0;
            for (int i = arr.length - 1; i > 0; i--) {
                sum = sum + arr[i] - mid;
                if (sum < 0) {
                    sum = 0;
                }

            }
            return sum + arr[0] <= mid;
        }
    }
}
