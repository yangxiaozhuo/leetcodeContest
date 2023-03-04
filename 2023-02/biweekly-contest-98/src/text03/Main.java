package text03;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/02/18
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,1,4};
        System.out.println(solution.minImpossibleOR(nums));
    }
}

class Solution {
    public int minImpossibleOR(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int temp = 1;
        for (int i = 0; i < 32; i++) {
            if (set.contains(temp)) {
                temp = temp << 1;
            } else {
                return temp;
            }
        }
        return 0;
    }
}