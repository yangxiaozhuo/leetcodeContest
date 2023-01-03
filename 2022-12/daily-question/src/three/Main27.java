package three;

/**
 * 2027. 转换字符串的最少操作次数
 *
 * @author yangxiaozhuo
 * @date 2022/12/27
 */
public class Main27 {
    class Solution {
        public int minimumMoves(String s) {
            int res = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'X') {
                    i = i + 2;
                    res++;
                }
            }
            return res;
        }
    }
}
