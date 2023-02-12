import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/01/29
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{1,3,5,7,2,1,4};
        System.out.println(solution.putMarbles(ints, 3));
    }
    static class Solution {
        public long putMarbles(int[] weights, int k) {
            if (k == weights.length) {
                return 0;
            }
            long[] nums = new long[weights.length - 1];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = weights[i + 1] + weights[i];
            }
            Arrays.sort(nums);
            long res = 0;
            for (int i = 0; i < k; i++) {
                res = res + nums[nums.length - 1 - i];
                res = res - nums[i];
            }
            return res;
        }
    }
}
