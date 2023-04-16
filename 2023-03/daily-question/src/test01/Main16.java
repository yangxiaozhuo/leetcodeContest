package test01;

import java.util.HashMap;

/**
 * @author yangxiaozhuo
 * @date 2023/03/16
 */
public class Main16 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{3, 2, 1, 4, 5};
        System.out.println(solution.countSubarrays(ints, 4));
    }

    static class Solution {
        public int countSubarrays(int[] nums, int k) {
            int index = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == k) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                return 0;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            int t = 0;
            for (int i = index - 1; i >= 0; i--) {
                if (nums[i] < k) {
                    t--;
                } else {
                    t++;
                }
                map.put(t, map.getOrDefault(t, 0) + 1);
            }
            int res = 1;
            res += map.getOrDefault(0, 0);
            res += map.getOrDefault(1, 0);
            map.put(0, map.getOrDefault(0, 0) + 1);
            System.out.println(res);
            t = 0;
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] < k) {
                    t--;
                } else {
                    t++;
                }
                if (t == 0) {
                    res++;
                }
                res += map.getOrDefault(-t, 0);
                res += map.getOrDefault(-t + 1, 0);
            }
            return res;
        }
    }
}
