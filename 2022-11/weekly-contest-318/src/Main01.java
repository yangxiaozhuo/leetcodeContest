import java.util.Arrays;

public class Main01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.applyOperations(nums)));
    }
    static class Solution {
        public int[] applyOperations(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if(nums[i] == nums[i + 1]) {
                    nums[i] = nums[i] * 2;
                    nums[i + 1] = 0;
                }
            }
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    continue;
                } else {
                    nums[j] = nums[i];
                    j++;
                }
            }
            for (int i = j; i < nums.length; i++) {
                nums[i] = 0;
            }
            return nums;
        }
    }
}