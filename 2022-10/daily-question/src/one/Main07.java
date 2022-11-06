package one;

/**
 * 1800. 最大升序子数组和
 *
 * @author yangxiaozhuo
 * @date 2022/10/07
 */
public class Main07 {
    class Solution {
        public int maxAscendingSum(int[] nums) {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] > nums[i - 1]) {
                    sum[i] = sum[i - 1] + nums[i];
                } else sum[i] = nums[i];
            }
            int res = sum[0];
            for(int i = 1;i < sum.length; i++){
                res = Math.max(res, sum[i]);
            }
            return res;
        }
    }
}
