package text03;

import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints1 = new int[]{4,7,8,15,3,5};
        int[] ints2 = new int[]{4,7,15,8,3,5};
        System.out.println(solution.findValidSplit(ints1));
        System.out.println(solution.findValidSplit(ints2));
    }
}

class Solution {
    public int findValidSplit(int[] nums) {
        int l = 0;
        int max = 1;
        while (max < nums.length - 1 && l < max) {
            for (int index = max; index < nums.length; index++) {
                if (gcd(nums[l], nums[index]) != 1) {
                    max = Math.max(max, index);
                }
            }
            l++;
        }
        if (max == nums.length - 1) {
            return -1;
        } else {
            return l;
        }
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}