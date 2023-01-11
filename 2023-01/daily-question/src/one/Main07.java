package one;

/**
 * 1658. 将 x 减到 0 的最小操作数
 *
 * @author yangxiaozhuo
 * @date 2023/01/07
 */
public class Main07 {
    class Solution {
        public int minOperations(int[] nums, int x) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int target = sum - x;
            int res = -1;
            int l = 0;
            int r = 0;
            int presum = 0;
            while (r < nums.length) {
                presum += nums[r];
                r++;
                while (presum > target && l < nums.length) {
                    presum -= nums[l];
                    l++;
                }
                if (presum == target) {
                    res = Math.max(res, r - l);
                }
            }
            return res == -1 ? -1 : nums.length - res;
        }
    }
}
