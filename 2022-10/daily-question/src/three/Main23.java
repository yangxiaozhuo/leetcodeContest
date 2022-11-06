package three;

/**
 * 1768. 交替合并字符串
 *
 * @author yangxiaozhuo
 * @date 2022/10/23
 */
public class Main23 {
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder res = new StringBuilder();
            int i = 0;
            for (; i < word1.length() && i < word2.length(); i++) {
                res.append(word1.charAt(i));
                res.append(word2.charAt(i));
            }
            if (i < word1.length()) {
                res.append(word1.substring(i));
            } else {
                res.append(word2.substring(i));
            }
            return res.toString();
        }
    }
}
