package test01;

import java.util.HashMap;

/**
 * @author yangxiaozhuo
 * @date 2023/03/10
 */
public class Main10 {
    public static void main(String[] args) {
//        [8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2]
//        148
        int[] nums = new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2};
        Solution solution = new Solution();
        System.out.println(solution.minSubarray(nums,148));
    }
    static class Solution {
        public int minSubarray(int[] nums, int p) {
            long sum = 0;
            for(int num : nums) {
                sum += num;
            }
            if(sum % p == 0) {
                return 0;
            }
            int target = (int)(sum % p);
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum2 = 0;
            int res = nums.length;
            map.put(0, -1);
            for(int i = 0; i < nums.length; i++) {
                sum2 += nums[i];
                sum2 = sum2 % p;
                int t = (sum2 + p - target) % p;
                res = Math.min(res, i - map.getOrDefault(t, - nums.length));
                map.put(sum2, i);
            }
            if(res == nums.length) {
                res = -1;
            }
            return res;
        }
    }
}