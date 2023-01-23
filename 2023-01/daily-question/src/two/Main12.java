package two;

import java.util.HashMap;
import java.util.List;

/**
 * 1807. 替换字符串中的括号内容
 *
 * @author yangxiaozhuo
 * @date 2023/01/12
 */
public class Main12 {
    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            HashMap<String, String> map = new HashMap<>();
            for(List<String> list : knowledge) {
                map.put(list.get(0),list.get(1));
            }
            StringBuilder res = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    i = fun(res, map, i,chars);
                } else {
                    res.append(chars[i]);
                }
            }
            return res.toString();
        }

        private int fun(StringBuilder res, HashMap<String, String> map, int start, char[] chars) {
            int end = start;
            StringBuilder sb = new StringBuilder();
            for (int i = start + 1; i < chars.length; i++) {
                if (chars[i] == ')') {
                    end = i;
                    break;
                }
                sb.append(chars[i]);
            }
            String string = sb.toString();
            if (map.containsKey(string)) {
                res.append(map.get(string));
            } else {
                res.append("(").append(string).append(")");
            }
            return end;
        }
    }
}
