package text01;


import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/04/01
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{5, 1, 1, 2, 0, 0};
    }
}

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    return nums1[i];
                }
            }
        }
        int min = nums1[0];
        int max = nums2[0];
        if (max > min) {
            return min * 10 + max;
        } else {
            return max * 10 + min;
        }
    }
}