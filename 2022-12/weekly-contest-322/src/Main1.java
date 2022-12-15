import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yangxiaozhuo
 * @date 2022/12/04
 */
public class Main1 {
    public static void main(String[] args) {
    }
    static class Solution {
        public boolean isCircularSentence(String sentence) {
            String[] s = sentence.split(" ");
            for (int i = 0; i < s.length; i++) {
                String s1 = s[i];
                String s2 = s[(i + 1) % s.length];
                if(s1.charAt(s1.length() - 1) != s2.charAt(0)) {
                    return false;
                }
            }
            return true;
        }
    }
}
