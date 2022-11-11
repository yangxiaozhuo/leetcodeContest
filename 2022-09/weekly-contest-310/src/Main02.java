import java.util.HashSet;

/**
 * 2405. 子字符串的最优划分
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main02 {
    class Solution {
        public int partitionString(String s) {
            HashSet<Character> set = new HashSet<>();
            char[] chars = s.toCharArray();
            int res = 0;
            for (int i = 0; i < chars.length; i++) {
                if (set.contains(chars[i])) {
                    res++;
                    set = new HashSet<>();
                }
                set.add(chars[i]);
            }
            return set.isEmpty() ? res : res + 1;
        }
    }
}
