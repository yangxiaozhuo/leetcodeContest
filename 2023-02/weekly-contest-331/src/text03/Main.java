package text03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{24, 1, 55, 46, 4, 61, 21, 52};
        System.out.println(solution.minCapability(ints, 3));
    }
}

class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 0;
        int r = 1000000000;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(mid, nums, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] nums, int k) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {

            } else {
                temp++;
                i++;
            }
        }
        return temp >= k;
    }
}