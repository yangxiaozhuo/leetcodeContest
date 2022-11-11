import java.util.HashSet;

/**
 * 2395. 和相等的子数组
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main01 {
    class Solution {
        public boolean findSubarrays(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length - 1; i++) {
                if (set.contains(nums[i] + nums[i + 1])) {
                    return true;
                } else {
                    set.add(nums[i] + nums[i + 1]);
                }
            }
            return false;
        }
    }
}
