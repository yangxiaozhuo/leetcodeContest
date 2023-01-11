package two;

/**
 * @author yangxiaozhuo
 * @date 2023/01/11
 */
public class Main11 {
    class Solution {
        public boolean digitCount(String num) {
            char[] chars = num.toCharArray();
            int[] nums = new int[10];
            for(char c : chars) {
                nums[c - '0']++;
            }
            for(int i = 0; i < chars.length; i++) {
                if(nums[i] != chars[i] - '0') {
                    return false;
                }
            }
            return true;
        }
    }
}
