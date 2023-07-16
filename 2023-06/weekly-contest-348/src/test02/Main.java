package test02;

/**
 * @author yangxiaozhuo
 * @date 2023/06/04
 */
public class Main {
}

class Solution {
    public int semiOrderedPermutation(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int one = -1;
        int n = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                one = i;
            }
            if (nums[i] == nums.length) {
                n = i;
            }
        }
        if (one < n) {
            return one - 1 + nums.length - n - 1;
        }
        return one - 1 + nums.length - n - 1 - 1;
    }
}