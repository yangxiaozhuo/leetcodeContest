package text01;

import java.util.*;

/**
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 *
 * @author yangxiaozhuo
 * @date 2023/02/08
 */
public class Main08 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(solution.removeSubfolders(strings));

    }

    static class Solution {
        public List<String> removeSubfolders(String[] folder) {
            ArrayList<String> res = new ArrayList<>();
            HashSet<String> set = new HashSet<>();
            Arrays.stream(folder).forEach((fold) -> set.add(fold));
            for (String key : set) {
                boolean flag = true;
                String temp = key;
                while (key.length() > 1) {
                    key = key.substring(0, key.lastIndexOf('/'));
                    if (set.contains(key)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.add(temp);
                }
            }
            return res;
        }
    }
}
