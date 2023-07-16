package text04;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/04/16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{10, 5, 10, 30, 70, 4, 2, 6, 8, 4}));
    }
}

//[6,10,15]  4
//[4,2,6,3] 5
class Solution {
    public int minOperations(int[] nums) {
        int one = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                one++;
            }
        }
        if (one != 0) {
            return nums.length - one;
        }
        for (int i = 1; i < nums.length; i++) {
            int t = gcd(nums[i], nums[i - 1]);
            if (t == 1) {
                return nums.length;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            int t = gcd(nums[i], nums[i - 1]);
            if (i >= 2) {
                int t2 = gcd(t, nums[i - 2]);
                if (t2 == 1) {
                    return 1 + nums.length;
                }
            }
            if (i < nums.length - 1) {
                int t2 = gcd(t, nums[i + 1]);
                if (t2 == 1) {
                    return 1 + nums.length;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            res = Math.min(res, fun(nums, i));
        }
        if (res != Integer.MAX_VALUE) {
            return res + nums.length - 1;
        }
        return -1;
    }

    private int fun(int[] nums, int start) {
        int temp = gcd(nums[start], nums[start + 1]);
        int res = 1;
        for (int i = start + 2; i < nums.length; i++) {
            temp = gcd(temp, nums[i]);
            res++;
            if (temp == 1) {
                return res;
            }
        }
        return Integer.MAX_VALUE;
    }


    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}