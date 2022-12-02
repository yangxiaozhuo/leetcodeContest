package three;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * 788. 旋转数字
 *
 * @author yangxiaozhuo
 * @date 2022/09/25
 */
public class Main25 {
    class Solution {
        public int rotatedDigits(int n) {
            int res = 0;
            for(int i = 1; i <= n; i++) {
                if(fun(i)) {
                    res++;
                }
            }
            return res;
        }
        public boolean fun(int n) {
            String s = n + "";
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '3'||c == '4'|| c=='7') {
                    return false;
                } else {
                    set.add(c);
                }
            }
            if(set.contains('2')||set.contains('5')||set.contains('6')||set.contains('9')) {
                return true;
            }
            return false;
        }
    }
}
