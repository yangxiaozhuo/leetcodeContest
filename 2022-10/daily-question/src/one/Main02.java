package one;

/**
 * 777. 在LR字符串中交换相邻字符
 *
 * @author yangxiaozhuo
 * @date 2022/10/02
 */
public class Main02 {
    class Solution {
        public boolean canTransform(String start, String end) {
            int i = 0;
            int j = 0;
            int n = start.length() - 1;
            while (true) {
                while (i <= n && start.charAt(i) == 'X') {
                    i++;
                }
                while (j <= n && end.charAt(j) == 'X') {
                    j++;
                }
                if (i > n && j > n) {
                    return true;
                }
                if (i > n || j > n) {
                    return false;
                }
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                if (start.charAt(i) == 'L' && j > i) {
                    return false;
                }
                if (start.charAt(i) == 'R' && i > j) {
                    return false;
                }
                i++;
                j++;
            }
        }
    }
}
