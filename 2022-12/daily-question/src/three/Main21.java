package three;

/**
 * 1753. 移除石子的最大得分
 *
 * @author yangxiaozhuo
 * @date 2022/12/21
 */
public class Main21 {
    class Solution {
        public int maximumScore(int a, int b, int c) {
            if (a > b + c) {
                return b + c;
            }
            if (b > a + c) {
                return a + c;
            }
            if (c > a + b) {
                return a + b;
            }
            return (a + b + c) / 2;
        }
    }
}
