package test02;

/**
 * @author yangxiaozhuo
 * @date 2023/05/21
 */
public class Main {
}
class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char c = chars[i];
            char c2 = chars[chars.length - 1 - i];
            if (c != c2) {
                chars[i] = (char) Math.min(c, c2);
                chars[chars.length - 1 - i] = (char) Math.min(c, c2);
            }
        }
        return new String(chars);
    }
}