package one;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2022/12/07
 */
public class Main07 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int[] b = {1,1,2,2,2,2};
        Solution solution = new Solution();
        System.out.println(solution.minOperations(a, b));
    }
    static class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < nums1.length; i++) {
                sum1 += nums1[i];
            }
            for (int i = 0; i < nums2.length; i++) {
                sum2 += nums2[i];
            }
            int res = 0;
            if (sum2 < sum1) {
                int[] a = nums1;
                nums1 = nums2;
                nums2 = a;
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int dic = Math.abs(sum1 - sum2);
            int l = 0;
            int r = nums2.length - 1;
            while (l < nums1.length && r >= 0) {
                if (dic <= 0) {
                    return res;
                }
                int a = 6 - nums1[l];
                int b = nums2[r] - 1;
                if (a > b) {
                    l++;
                    dic -= a;
                }else {
                    r--;
                    dic -= b;
                }
                res++;
            }
            while (l < nums1.length) {
                if (dic <= 0) {
                    return res;
                }
                dic -= (6 - nums1[l]);
                l++;
                res++;
            }
            while (r >= 0) {
                if (dic <= 0) {
                    return res;
                }
                int b = nums2[r] - 1;
                dic -= b;
                r--;
                res++;
            }
            if (dic <= 0) {
                return res;
            } else {
                return -1;
            }
        }
    }
}
