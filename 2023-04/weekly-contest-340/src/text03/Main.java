package text03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/04/09
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints1 = new int[]{1, 4, 1, 3};
        int[] ints2 = new int[]{4, 7, 15, 8, 3, 5};
    }
}

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid, nums, p)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] nums, int p) {
        int sum = 0;
        for (int i = 1; i < nums.length; ) {
            if (nums[i] - nums[i - 1] <= mid) {
                sum++;
                i = i + 2;
            } else {
                i++;
            }
        }
        return sum >= p;
    }
}