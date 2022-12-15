package two;

/**
 * 1827. 最少操作使数组递增
 *
 * @author yangxiaozhuo
 * @date 2022/12/11
 */
public class Main11 {
    class Solution {
        public int minOperations(int[] nums) {
            int res = 0;
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < max) {
                    res = res + max - nums[i] + 1;
                } else if(nums[i] == max) {
                    max = max + 1;
                    res++;
                } else {
                    max = nums[i];
                }
                System.out.println(max);
            }
            return res;
        }
    }
}
