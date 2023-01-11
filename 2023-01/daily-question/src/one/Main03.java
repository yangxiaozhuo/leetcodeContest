package one;

/**
 * 2042. 检查句子中的数字是否递增
 *
 * @author yangxiaozhuo
 * @date 2023/01/03
 */
public class Main03 {
    class Solution {
        public boolean areNumbersAscending(String s) {
            int pre = 0;
            for (String ss : s.split(" ")) {
                if (ss.charAt(0) <= 'z' && ss.charAt(0) >= 'a') {
                    continue;
                }
                int t = Integer.valueOf(ss);
                if (t <= pre) {
                    return false;
                } else {
                    pre = t;
                }
            }
            return true;
        }
    }
}
