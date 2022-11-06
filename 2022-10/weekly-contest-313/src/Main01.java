/**
 * 2427. 公因子的数目
 *
 * @author yangxiaozhuo
 * @date 2022/10/02
 * <p>
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 * <p>
 * 示例 1：
 * 输入：a = 12, b = 6
 * 输出：4
 * 解释：12 和 6 的公因子是 1、2、3、6 。
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.commonFactors(12, 6));
    }

    static class Solution {
        public int commonFactors(int a, int b) {
            int min = Math.min(a, b);
            int res = 0;
            for (int i = 1; i <= min; i++) {
                if (a % i == 0 && b % i == 0) {
                    res++;
                }
            }
            return res;
        }
    }
}
