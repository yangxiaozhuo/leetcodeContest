/**
 * 2460. 对数组执行操作
 *
 * @author yangxiaozhuo
 * @date 2022/11/06
 */
public class Main02 {
    public static void main(String[] args) {
        int[] nums = new int[]{9,18,10,13,17,9,19,2,1,18};
//        [9,18,10,13,17,9,19,2,1,18]
//        5
        Solution solution = new Solution();
        System.out.println(solution.maximumSubarraySum(nums, 5));
    }
    static class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            long res = 0;
            long[] sum = new long[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
            int l = 0;
            int r = 0;
            int[] times = new int[100010];
            while (r < nums.length) {
                while (r < nums.length && r - l < k) {
                    times[nums[r]]++;
                    while (times[nums[r]] > 1) {
                        times[nums[l]]--;
                        l++;
                    }
                    r++;
                }
                if (r - l == k) {
                    res = Math.max(res, sum[r] - sum[l]);
                }
                times[nums[l]]--;
                l++;
            }
            return res;
        }
    }
}
