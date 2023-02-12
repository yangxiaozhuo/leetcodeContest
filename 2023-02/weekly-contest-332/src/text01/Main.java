package text01;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{54, 6, 34, 66, 63, 52, 39, 62, 46, 75, 28, 65, 18, 37, 18, 13, 33, 69, 19, 40, 13, 10, 43, 61, 72};
    }
}

class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[l]);
            sb.append(nums[r]);
            res = res + Long.parseLong(sb.toString());
            l++;
            r--;
        }
        if (l == r) {
            res += nums[l];
        }
        return res;
    }
}