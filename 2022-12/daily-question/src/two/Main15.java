package two;

/**
 * 1945. 字符串转化后的各位数字之和
 *
 * @author yangxiaozhuo
 * @date 2022/12/15
 */
public class Main15 {
    class Solution {
        public int getLucky(String s, int k) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(c - 'a' + 1);
            }
            while (k-- > 0) {
                int t = 0;
                for (char c : sb.toString().toCharArray()) {
                    t = t + c - '0';
                }
                sb = new StringBuilder(t + "");
            }
            return Integer.parseInt(sb.toString());
        }
    }
}
