package one;

/**
 * 1796. 字符串中第二大的数字
 * @author yangxiaozhuo
 * @date 2022/12/03
 */
public class Main03 {
    class Solution {
        public int secondHighest(String s) {
            char[] chars = s.toCharArray();
            int[] num = new int[10];
            for(int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if(c <= '9' && c >= '0') {
                    num[c - '0']++;
                }
            }
            boolean flag = false;
            for(int i = 9; i >= 0; i--) {
                if(num[i] > 0) {
                    if(flag) {
                        return i;
                    } else {
                        flag = true;
                    }
                }
            }
            return -1;
        }
    }
}
