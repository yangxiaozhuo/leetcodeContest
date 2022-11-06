package three;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 *
 * @author yangxiaozhuo
 * @date 2022/10/30
 */
public class Main30 {
    class Solution {
        List<String> res;

        public List<String> letterCasePermutation(String s) {
            res = new ArrayList<>();
            StringBuilder sb = new StringBuilder(s);
            dfs(sb, 0);
            return res;
        }

        private void dfs(StringBuilder s, int index) {
            if (index == s.length()) {
                res.add(s.toString());
                return;
            }
            if (s.charAt(index) <= 'z' && s.charAt(index) >= 'a') {
                char c = s.charAt(index);
                char to = (char) (c + ('Z' - 'z'));
                s.setCharAt(index, to);
                dfs(s, index + 1);
                s.setCharAt(index, c);
                dfs(s, index + 1);
            } else if (s.charAt(index) <= 'Z' && s.charAt(index) >= 'A') {
                char c = s.charAt(index);
                char to = (char) (c - ('Z' - 'z'));
                s.setCharAt(index, to);
                dfs(s, index + 1);
                s.setCharAt(index, c);
                dfs(s, index + 1);
            } else {
                dfs(s, index + 1);
            }
        }
    }
}
