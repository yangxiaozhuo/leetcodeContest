package one;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 *
 * @author yangxiaozhuo
 * @date 2023/01/06
 */
public class Main06 {
    class Solution {
        public int countEven(int num) {
            int res = 0;
            for(int i = 1; i <= num; i++) {
                if(fun(i)) {
                    res++;
                }
            }
            return res;
        }
        public boolean fun(int i) {
            int res = 0;
            while(i > 0) {
                res = res + i % 10;
                i = i / 10;
            }
            return res % 2 == 0;
        }
    }
}
