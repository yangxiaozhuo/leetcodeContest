package three;

/**
 * 面试题 01.09. 字符串轮转
 *
 * @author yangxiaozhuo
 * @date 2022/09/29
 */
public class Main29 {
    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if(s1.length()!=s2.length()) return false;
            return (s1+s1).contains(s2);
        }
    }
}
