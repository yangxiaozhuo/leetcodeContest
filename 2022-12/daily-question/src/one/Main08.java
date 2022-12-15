package one;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 *
 * @author yangxiaozhuo
 * @date 2022/12/10
 */
public class Main08 {
    class Solution {
        public boolean squareIsWhite(String coordinates) {
            int res = 0;
            res = coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '0' + 1;
            return res % 2 != 0;
        }
    }
}
