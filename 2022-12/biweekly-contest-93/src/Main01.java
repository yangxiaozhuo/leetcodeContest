/**
 * @author yangxiaozhuo
 * @date 2022/12/10
 */
public class Main01 {
    class Solution {
        public int maximumValue(String[] strs) {
            int res = 0;
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if (iszm(str)) {
                    res = Math.max(str.length(),res);
                } else {
                    res = Math.max(Integer.parseInt(str),res);
                }
            }
            return res;
        }

        private boolean iszm(String str) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c <= 'z' && c >= 'a') {
                    return true;
                }
            }
            return false;
        }
    }
}
