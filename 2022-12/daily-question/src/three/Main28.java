package three;

/**
 * 1750. 删除字符串两端相同字符后的最短长度
 *
 * @author yangxiaozhuo
 * @date 2020/12/28
 */
public class Main28 {
    class Solution {
        public int minimumLength(String s) {
            char[] chars = s.toCharArray();
            int l = 0;
            int r = chars.length - 1;
            while (l < r && chars[l] == chars[r]) {
                char c = chars[l];
                while (l <= r && chars[l] == c) {
                    l++;
                }
                while (l <= r && chars[r] == c) {
                    r--;
                }
            }
            return r - l + 1;
        }
    }
}
