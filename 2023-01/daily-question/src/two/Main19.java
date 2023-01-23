package two;

/**
 * @author yangxiaozhuo
 * @date 2023/01/19
 */
public class Main19 {
    class Solution {
        public boolean strongPasswordCheckerII(String password) {
            if (password.length() < 8) {
                return false;
            }
            boolean lowercase = false;
            boolean uppercase = false;
            boolean num = false;
            boolean other = false;
            char[] chars = password.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i != 0) {
                    if (chars[i] == chars[i - 1]) {
                        return false;
                    }
                    if (chars[i] <= '9' && chars[i] >= '0') {
                        num = true;
                    } else if (chars[i] <= 'Z' && chars[i] >= 'A') {
                        uppercase = true;
                    } else if (chars[i] <= 'z' && chars[i] >= 'a') {
                        lowercase = true;
                    } else {
                        other = true;
                    }
                } else {
                    if (chars[i] <= '9' && chars[i] >= '0') {
                        num = true;
                    } else if (chars[i] <= 'Z' && chars[i] >= 'A') {
                        uppercase = true;
                    } else if (chars[i] <= 'z' && chars[i] >= 'a') {
                        lowercase = true;
                    } else {
                        other = true;
                    }
                }
            }
            return uppercase && lowercase && num && other;
        }
    }
}
