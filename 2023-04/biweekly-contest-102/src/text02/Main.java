package text02;

/**
 * @author yangxiaozhuo
 * @date 2023/04/15
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 2};  //[998,2]  true
    }
}

class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] sum = new long[nums.length];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            sum[i] = max + nums[i];
        }
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }
        return sum;
    }
}