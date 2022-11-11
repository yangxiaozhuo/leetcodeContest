/**
 * 2399. 检查相同字母间的距离
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main01 {
    class Solution {
        public boolean checkDistances(String s, int[] distance) {
            int[] nums = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int t = s.charAt(i) - 'a';
                if (nums[t] == 0) {
                    nums[t] = i + 1;
                } else {
                    if (distance[t] != i - nums[t]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
