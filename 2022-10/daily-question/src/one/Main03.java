package one;

/**
 * 1784. 检查二进制字符串字段
 *
 * @author yangxiaozhuo
 * @date 2022/10/03
 */
public class Main03 {
    class Solution {
        public boolean checkOnesSegment(String s) {
            int res = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='1') {
                    res++;
                    while(i < s.length() && s.charAt(i) == '1') {
                        i++;
                    }
                    i--;
                }
            }
            return res < 2;
        }
    }
}
