/**
 * @author yangxiaozhuo
 * @date 2022/11/27
 */
public class Main02 {
    class Solution {
        public int appendCharacters(String s, String t) {
            int index = 0;
            int i = 0;
            while (i < s.length() && index < t.length()) {
                if (s.charAt(i) == t.charAt(index)) {
                    i++;
                    index++;
                }else {
                    i++;
                }
            }
            if (index == t.length()) {
                return 0;
            }
            return t.length() - index;
        }
    }
}
