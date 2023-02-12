package text02;

import javax.print.attribute.standard.NumberUp;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[]{"aba","bcb","ece","aa","e"};
//        int[] ints = new int[]{0,0,0,0,0,0};
//        System.out.println(solution.countFairPairs(ints, 0,0));
        int[] ints = new int[]{0,1,7,4,4,5};
        System.out.println(solution.countFairPairs(ints, 3,6));
    }
}
//[0,0,0,0,0,0]
//        0
//        0
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int r = findMinAndEq(nums, upper - nums[i]);
            int l = findBigAndEq(nums, lower - nums[i]);
            if (l > r) {
                continue;
            }
            if (nums[l] <lower -  nums[i]) {
                continue;
            }
            if (nums[r] > upper - nums[i]) {
                continue;
            }
            if (i >= l && i <= r) {
                res = res + r - l;
            } else {
                res = res + r - l + 1;
            }
        }
        return res / 2;
    }

    private int findBigAndEq(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int findMinAndEq(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        while (l < r) {
            int mid = l + r + 1>> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}