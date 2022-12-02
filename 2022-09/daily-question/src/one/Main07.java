package one;

import java.util.ArrayList;

/**
 * 1592. 重新排列单词间的空格
 *
 * @author yangxiaozhuo
 * @date 2022/09/07
 */
public class Main07 {
    class Solution {
        public String reorderSpaces(String text) {
            char[] chars = text.toCharArray();
            int blank = 0;
            ArrayList<String> strings = new ArrayList<>();
            int l = 0;
            int r = 0;
            while (r < chars.length) {
                if (chars[r] == ' ') {
                    if (r != l) {
                        strings.add(text.substring(l, r));
                    }
                    blank++;
                    r++;
                    l = r;
                } else {
                    r++;
                }
            }
            if (r != l) {
                strings.add(text.substring(l, r));
            }
            if (strings.size() == 1) return strings.get(0) + fun(blank);
            int t = blank / (strings.size() - 1);
            StringBuffer stringBuffer = new StringBuffer();
            String tBlank = fun(t);
            for (int i = 0; i < strings.size() - 1; i++) {
                stringBuffer.append(strings.get(i));
                stringBuffer.append(tBlank);
            }
            stringBuffer.append(strings.get(strings.size() - 1));
            stringBuffer.append(fun(blank % (strings.size() - 1)));
            return stringBuffer.toString();
        }

        public String fun(int t) {
            if (t == 0) return "";
            StringBuffer stringBuffer = new StringBuffer(t);
            for (int i = 0; i < t; i++) {
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
    }
}
