package text01;


import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/02/19
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{5, 1, 1, 2, 0, 0};
    }
}

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] nums = new int[1010];
        for (int i = 0; i < nums1.length; i++) {
            nums[nums1[i][0]] += nums1[i][1];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[nums2[i][0]] += nums2[i][1];
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                temp++;
            }
        }
        int[][] res = new int[temp][2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                res[index][0] = i;
                res[index][1] = nums[i];
                index++;
            }
        }
        return res;
    }
}