package text03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/04/16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getSubarrayBeauty(new int[]{1, -1, -3, -2, 3}, 3, 2)));
    }
}

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] arr = new int[110];
        for (int i = 0; i < k; i++) {
            arr[nums[i] + 50]++;
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k; i <= nums.length; i++) {
            res[i - k] = fun(arr, x);
            if(i < nums.length)
                arr[nums[i] + 50]++;
            arr[nums[i - k] + 50]--;
        }
        return res;
    }

    private int fun(int[] arr, int x) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= x || i >= 50) {
                return i - 50;
            }
        }
        return 0;
    }
}