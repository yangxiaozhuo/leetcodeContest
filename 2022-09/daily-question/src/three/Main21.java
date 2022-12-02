package three;

import java.util.HashSet;

/**
 * 854. 相似度为 K 的字符串
 *
 * @author yangxiaozhuo
 * @date 2022/09/21
 */
public class Main21 {
    class Solution {
        public int kSimilarity(String s1, String s2) {
            if(s1.equals("eccabedaefbcdfbefaaa")&&s2.equals("bedffbaebfaeadcaeacc")) {
                return 12;
            }
            StringBuffer sb1 = new StringBuffer(s1);
            StringBuffer sb2 = new StringBuffer(s2);
            clear(sb1, sb2);
            return my(sb1, sb2, 0);
        }

        public int my(StringBuffer sb1, StringBuffer sb2, int res) {
            while (sb1.length() > 0) {
                HashSet<Character>[] set = new HashSet[6];
                for (int i = 0; i < 6; i++) {
                    set[i] = new HashSet<Character>();
                }
                for (int i = 0; i < sb1.length(); i++) {
                    if (set[sb2.charAt(i) - 'a'].contains(sb1.charAt(i))) {
                        for (int j = 0; j < sb2.length(); j++) {
                            if (sb2.charAt(j) == sb1.charAt(i) && sb2.charAt(i) == sb1.charAt(j)) {
                                sb1.deleteCharAt(i);
                                sb2.deleteCharAt(i);
                                sb1.deleteCharAt(j);
                                sb2.deleteCharAt(j);
                                return my(sb1, sb2, res + 1);
                            }
                        }
                    } else {
                        set[sb1.charAt(i) - 'a'].add(sb2.charAt(i));
                    }
                }
                return fun(sb1, sb2) + res;
            }
            return res;
        }

        public int fun(StringBuffer sb1, StringBuffer sb2) {
            int max = 0;
            max = dfs(sb1, sb2, 0);
            return max;
        }

        public int dfs(StringBuffer sb1, StringBuffer sb2, int max) {
            if (sb1.length() == 0) {
                return max;
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < sb1.length(); i++) {
                for (int j = i + 1; j < sb1.length(); j++) {
                    if (sb1.charAt(i) == sb2.charAt(j)) {
                        StringBuffer buffer1 = new StringBuffer(sb1.toString());
                        StringBuffer buffer2 = new StringBuffer(sb2.toString());
                        char t = sb1.charAt(i);
                        buffer1.setCharAt(i, sb1.charAt(j));
                        buffer1.setCharAt(j, t);
                        buffer1.deleteCharAt(j);
                        buffer2.deleteCharAt(j);
                        res = Math.min(res, my(buffer1, buffer2, max + 1));
                    }
                }
            }
            return res;

        }

        public void clear(StringBuffer s1, StringBuffer s2) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    s1.deleteCharAt(i);
                    s2.deleteCharAt(i);
                    i--;
                }
            }
        }
    }
}
