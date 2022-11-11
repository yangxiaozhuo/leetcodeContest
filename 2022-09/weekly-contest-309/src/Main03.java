/**
 * 2401. 最长优雅子数组
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main03 {
    class Solution {

        public int longestNiceSubarray(int[] nums) {
            int max = 1;
            int _or = 0;
            for (int i = 0; i < nums.length; i++) {
                int j = i + 1;
                _or = nums[i];
                while (j < nums.length) {
                    if((nums[j] & nums[j - 1]) == 0 && ((nums[j] & _or) == 0) ){
                        _or = _or | nums[j];
                        max = Math.max(max, j - i + 1);
                    } else {
                        _or = 0;
                        max = Math.max(max, j - i);
                        break;
                    }
                    j++;
                }
            }
            return max;
        }
    }
}
