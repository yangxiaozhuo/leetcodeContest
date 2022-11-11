/**
 * 2419. 按位与最大的最长子数组
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main02 {
    class Solution {
        public int longestSubarray(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max,nums[i]);
            }
            int left = 0;
            int right = 0;
            int res = 0;
            while (right < nums.length) {
                if (nums[right] == max) {
                    while (right < nums.length && nums[right] == max) {
                        right++;
                    }
                    res = Math.max(res, right - left);
                } else {
                    right++;
                }
                left = right;
            }
            return res;
        }
    }
}
