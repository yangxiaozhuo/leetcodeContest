package one;

/**
 * 1582. 二进制矩阵中的特殊位置
 *
 * @author yangxiaozhuo
 * @date 2022/09/04
 */
public class Main04 {
    class Solution {
        public int numSpecial(int[][] mat) {
            int[] rows = new int[mat.length];
            int[] cols = new int[mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    rows[i] += mat[i][j];
                    cols[j] += mat[i][j];
                }
            }
            int res = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) res++;
                }
            }
            return res;
        }
    }
}
