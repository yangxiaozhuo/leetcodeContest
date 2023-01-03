package three;

/**
 * 2011. 执行操作后的变量值
 *
 * @author yangxiaozhuo
 * @date 2022/12/23
 */
public class Main23 {
    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int res = 0;
            for (String s : operations) {
                if (s.charAt(1) == '-') {
                    res--;
                } else {
                    res++;
                }
            }
            return res;
        }
    }
}
