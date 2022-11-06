package one;

/**
 * 921. 使括号有效的最少添加
 *
 * @author yangxiaozhuo
 * @date 2022/10/04
 */
public class Main04 {
    class Solution {
        public int minAddToMakeValid(String s) {
            char[] chars = new char[1010];
            int index = 0;
            for(int i = 0; i < s.length(); i++) {
                if(index == 0 || s.charAt(i) == '(') {
                    chars[index++] = s.charAt(i);
                    continue;
                }
                if(s.charAt(i) == ')' && chars[index-1] == '(') {
                    index--;
                } else {
                    chars[index++] = s.charAt(i);
                }
            }
            return index;
        }
    }
}
