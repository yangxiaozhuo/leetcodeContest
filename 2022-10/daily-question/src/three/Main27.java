package three;

/**
 * 1822. 数组元素积的符号
 * @author yangxiaozhuo
 * @date 2022/10/27
 */
public class Main27 {
    class Solution {
        public int arraySign(int[] nums) {
            int res = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] < 0) {
                    res++;
                } else if(nums[i] == 0) {
                    return 0;
                }
            }
            return res % 2 == 0 ? 1 : -1;
        }
    }
}
