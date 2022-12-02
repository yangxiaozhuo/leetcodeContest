package three;

/**
 * 面试题 17.19. 消失的两个数字
 *
 * @author yangxiaozhuo
 * @date 2022/09/27
 */
public class Main27 {
    class Solution {
        public int[] missingTwo(int[] nums) {
            int n = nums.length;
            int a = n+1;
            int b = n+2;
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(nums[i]) - 1 < nums.length) {
                    nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
                } else {
                    if (Math.abs(nums[i]) - nums.length == 1) {
                        a = -Math.abs(nums[i]);
                    } else {
                        b = -Math.abs(nums[i]);
                    }
                }
            }
            int[] res = new int[2];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    res[index++] = i + 1;
                    if (index == 2) return res;
                }
            }
            if (a > 0) {
                res[index++] = a;
            }
            if (index == 2) return res;
            if (b > 0) {
                res[index++] = b;
            }
            return res;
        }
    }
}
