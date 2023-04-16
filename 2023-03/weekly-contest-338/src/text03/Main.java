package text03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints1 = new int[]{4, 7, 8, 15, 3, 5};
        int[] ints2 = new int[]{4, 7, 15, 8, 3, 5};
    }
}

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> res = new ArrayList<>();
        Arrays.sort(nums);
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            res.add(fun(queries[i], sum, nums));
        }
        return res;
    }

    private Long fun(long query, long[] sum, int[] nums) {
        int target = find(nums, query);   //nums[target] > query
        long res = 0;
        //0 - target - 1 都小于q
        res = query * target - sum[target];
        //target    nums.length -1 都大于sum
        res = res + sum[nums.length] - sum[target] - query * (nums.length - target);
        return res;
    }

    private int find(int[] nums, long query) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > query) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] < query) {
            return nums.length;
        }
        return l;
    }
}