package text02;

import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/02/19
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{58, 42, 8, 75, 28};  //30
        System.out.println(solution.minOperations(39));
        System.out.println(solution.minOperations(54));
        System.out.println(solution.minOperations(3));
    }
}

class Solution {
    public int minOperations(int n) {
        StringBuilder sb = new StringBuilder();
        int res = 0;
        int temp = 0;
        while (n != 0) {
            int t = n & 1;
            if (t == 1) {
                temp++;
            } else {
                if (temp <= 1) {
                    res += temp;
                    temp = 0;
                } else {
                    res++;
                    temp = 1;
                }
            }
            n = n/2;
        }
        res += Math.min(temp,2);
        return res;
    }
}