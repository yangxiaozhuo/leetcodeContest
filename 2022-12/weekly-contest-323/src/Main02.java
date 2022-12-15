import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2022/12/11
 */
public class Main02 {
    class Solution {
        public int longestSquareStreak(int[] nums) {
            Arrays.sort(nums);
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            int res = -1;
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(res, fun(nums[i], set));
            }
            return res;
        }

        private int fun(int num, HashSet<Integer> set) {
            int t = 0;
            while (set.contains(num)) {
                num = num * num;
                t++;
            }
            return t;
        }
    }
}
