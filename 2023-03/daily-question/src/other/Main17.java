package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxiaozhuo
 * @date 2023/03/09
 */
public class Main17 {

    class Solution {
        char[][] chars = new char[][]{{}, {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            dfs(res, new StringBuilder(), 0, digits);
            return res;
        }

        private void dfs(List<String> res, StringBuilder stringBuilder, int at, String digits) {
            if (at == digits.length()) {
                res.add(stringBuilder.toString());
                return;
            }
            for (int i = 0; i < chars[digits.charAt(at) - '0'].length; i++) {
                stringBuilder.append(chars[digits.charAt(at) - '0'][i]);
                dfs(res, stringBuilder, at+1,digits);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }

    }
}
