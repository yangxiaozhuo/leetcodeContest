/**
 * 2414. 最长的字母序连续子字符串的长度
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main02 {
    class Solution {
        public int longestContinuousSubstring(String s) {
            int res = 1;
            int r = 1;
            int l = 0;
            while (r < s.length()) {
                while (r < s.length() && s.charAt(r) - s.charAt(r - 1) == 1) {
                    r++;
                }
                res = Math.max(res, r - l);
                l = r;
                r++;
            }
            return res;
        }
    }
}
