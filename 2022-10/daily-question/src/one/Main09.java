package one;

/**
 * 856. 括号的分数
 *
 * @author yangxiaozhuo
 * @date 2022/10/09
 */
public class Main09 {
    class Solution {
        public int scoreOfParentheses(String S) {
            char[] chars = S.toCharArray();
            int res = 0;
            int lay = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    lay++;
                } else {
                    lay--;
                    if (chars[i - 1] == '(') {
                        res = res + (1 << lay);
                    }
                }
            }
            return res;
        }
    }
}
