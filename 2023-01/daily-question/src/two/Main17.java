package two;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. 统计一个数组中好对子的数目
 *
 * @author yangxiaozhuo
 * @date 2023/01/19
 */
public class Main17 {
    class Solution {
        public int countNicePairs(int[] nums) {
            int MOD = 1000_000_007;
            // int[][] dp = new int[nums.length][2];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] - rev(nums[i]);
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            long res = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                long value = entry.getValue();
                res = res + value * (value - 1) / 2;
                res = res % MOD;
            }
            return (int) res;
        }
        public int rev(int num) {
            int res = 0;
            while(num != 0) {
                res = res * 10 + num % 10;
                num = num / 10;
            }
            return res;
        }
    }
}
