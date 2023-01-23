/**
 * @author yangxiaozhuo
 * @date 2023/01/15
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int differenceOfSum(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            int mySum = 0;
            for (int i = 0; i < nums.length; i++) {
                mySum += fun(nums[i]);
            }
            return Math.abs(sum - mySum);
        }

        private int fun(int num) {
            int res = 0;
            while (num != 0) {
                res = res + num % 10;
                num /= 10;
            }
            return res;
        }
    }
}
