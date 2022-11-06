package three;

/**
 * 915. 分割数组
 *
 * @author yangxiaozhuo
 * @date 2022/10/24
 */
public class Main24 {
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int[] min = new int[nums.length];
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 0; i--) {
                temp = temp < nums[i] ? temp : nums[i];
                min[i] = temp;
            }
            for (int i = 0; i < nums.length - 1; i++) {
                temp = temp > nums[i] ? temp : nums[i];
                if (temp <= min[i + 1]) {
                    return i + 1;
                }
            }
            return nums.length - 1;
        }
    }
}
