package test3;

import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/05/13
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maximumOr(new int[]{8, 2, 1}, 2));
//        System.out.println(solution.maximumOr(new int[]{12, 9}, 1));
//        [93,79,9]
//        2
//        383
        System.out.println(solution.maximumOr(new int[]{93,79,9}, 2));
    }
}
class Solution {
    public long maximumOr(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int max = 0;
        int[] sum = new int[100];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = fun(nums[i], sum);
            max = Math.max(max, temp[i]);
        }
        long res = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == max) {
                long t = 0;
                for (int j = 0; j < nums.length; j++) {
                    long tt = nums[j];
                    if (j == i) {
                        tt = tt << k;
                    }
                    t = t | tt;
                }
                res = Math.max(res, t);
            }
        }
        return res;
    }
    private int fun(int num, int[] sum) {
        int res = 0;
        while (num != 0) {
            int t = num & 1;
            sum[res] += t;
            num = num >> 1;
            res++;
        }
        return res;
    }
}
class Solution2 {
    public long maximumOr(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int max = 0;
        int[] sum = new int[40];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = fun(nums[i], sum);
            max = Math.max(max, temp[i]);
        }
        long shouyi = 0;
        long index = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == max) {
                long tempshouyo = fun2(sum, k, nums[i]);
                if (shouyi < tempshouyo) {
                    shouyi = tempshouyo;
                    index = i;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            long tt = nums[i];
            if (i == index) {
                tt = tt << k;
            }
            res = res | tt;
        }
        return res;
    }

    private long fun2(int[] sum, int k, long num) {
        long num2 = num << k;
        long res = 0;
        long num3 = num;
        int index = 0;
        while (num != 0) {
            if ((num & 1) == 1 && sum[index] == 1) {
                res = res - (1L << index);
            }
            index++;
            num = num >> 1;
        }
        index = 0;
        while (num2 != 0) {
            if ((num2 & 1) == 1 && (sum[index] == 0 || (sum[index] == 1 && ((num3 >> index) & 1) == 1))) {
                res = res + (1L << index);
            }
            index++;
            num2 = num2 >> 1;
        }
        return res;
    }

    private int fun(int num, int[] sum) {
        int res = 0;
        while (num != 0) {
            int t = num & 1;
            sum[res] += t;
            num = num >> 1;
            res++;
        }
        return res;
    }
}