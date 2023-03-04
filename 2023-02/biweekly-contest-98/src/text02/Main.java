package text02;

import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/02/18
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{58, 42, 8, 75, 28};  //30
        System.out.println(solution.minimizeSum(nums));
    }
}

class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0] + nums[1] - nums[0];
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid, nums)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] nums) {
        if (nums[nums.length - 1] - nums[2] <= mid || nums[nums.length - 3] - nums[0] <= mid || nums[nums.length - 2] - nums[1] <= mid) {
            return true;
        }
        return false;
    }
}