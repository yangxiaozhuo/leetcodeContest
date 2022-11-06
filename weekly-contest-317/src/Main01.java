//2455. 可被三整除的偶数的平均值
/**
 * 给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
 * 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。
 * 示例 1：
 *
 * 输入：nums = [1,3,6,10,12,15]
 * 输出：9
 * 解释：6 和 12 是可以被 3 整除的偶数。(6 + 12) / 2 = 9 。
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,6,10,12,15};
        System.out.println(solution.averageValue(nums));
    }
}
class Solution {
    public int averageValue(int[] nums) {
        int sum = 0;
        int num = 0;
        for(int i = 0;i < nums.length; i++) {
            if(nums[i] % 3 == 0 && nums[i] % 2 == 0) {
                sum = sum + nums[i];
                num++;
            }
        }
        if(num == 0) {
            return 0;
        }
        return sum / num;
    }
}
