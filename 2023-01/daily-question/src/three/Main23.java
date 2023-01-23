package three;

/**
 * 2303. 计算应缴税款总额
 *
 * @author yangxiaozhuo
 * @date 2023/01/23
 */
public class Main23 {
    class Solution {
        public double calculateTax(int[][] brackets, int income) {
            double res = 0;
            int index = 0;
            int upper = 0;
            while(income > upper) {
                res = res + (Math.min(brackets[index][0], income) - upper) * brackets[index][1] / 100D;
                upper = brackets[index][0];
                index++;
            }
            return res;
        }
    }
}
