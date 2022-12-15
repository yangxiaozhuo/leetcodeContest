package one;

import java.util.HashSet;

/**
 * 1805. 字符串中不同整数的数目
 *
 * @author yangxiaozhuo
 * @date 2022/12/06
 */
public class Main06 {
    class Solution {
        public int numDifferentIntegers(String word) {
            HashSet<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char r = word.charAt(i);
                if (r <= '9' && r >= '0') {
                    sb.append(r);
                } else {
                    if (sb.length() != 0) {
                        set.add(fun(sb));
                        sb = new StringBuilder();
                    }
                }
            }
            if (sb.length() != 0) {
                set.add(fun(sb));
            }
            return set.size();
        }

        private String fun(StringBuilder sb) {
            int i = 0;
            while (i < sb.length() && sb.charAt(i) == '0') {
                i++;
            }
            return sb.substring(i);
        }
    }
}
