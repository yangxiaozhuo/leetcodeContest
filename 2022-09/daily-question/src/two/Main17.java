package two;

/**
 * 91624. 两个相同字符之间的最长子字符串
 *
 * @author yangxiaozhuo
 * @date 2022/09/17
 */
public class Main17 {
    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            int[] num = new int[26];
            int res = -1;
            for(int i = 0; i < s.length();i++) {
                int index = s.charAt(i) - 'a';
                if(num[index]==0) {
                    num[index] = i + 1;
                } else {
                    res = Math.max(res, i - num[index]);
                }
            }
            return res;
        }
    }
}
