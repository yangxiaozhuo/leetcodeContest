package two;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 1704. 判断字符串的两半是否相似
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main11 {
    class Solution {
        public boolean halvesAreAlike(String s) {
            HashSet<Character> set = new HashSet<>();
            char[] chars = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
            for (char c : chars) {
                set.add(c);
            }
            int num = 0;
            for (int i = 0; i < s.length() / 2; i++) {
                if (set.contains(s.charAt(i))) {
                    num++;
                }
            }
            for (int i = s.length() / 2; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    num--;
                }
            }
            return num == 0;
        }
    }
}
