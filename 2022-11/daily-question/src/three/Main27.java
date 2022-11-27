package three;

/**
 * 1752. 检查数组是否经排序和轮转得到
 *
 * @author yangxiaozhuo
 * @date 2022/11/27
 */
public class Main27 {
    class Solution {
        public boolean check(int[] nums) {
            int a = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > nums[(i + 1) % nums.length]) {
                    a++;
                }
            }
            return a <= 1;
        }
    }
}
