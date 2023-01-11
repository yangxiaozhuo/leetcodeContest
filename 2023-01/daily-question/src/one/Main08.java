package one;

/**
 * 2185. 统计包含给定前缀的字符串
 *
 * @author yangxiaozhuo
 * @date 2023/01/10
 */
public class Main08 {
    class Solution {
        public int prefixCount(String[] words, String pref) {
            int res = 0;
            for(String s : words) {
                if (s.startsWith(pref)) {
                    res++;
                }
            }
            return res;
        }
    }
}
