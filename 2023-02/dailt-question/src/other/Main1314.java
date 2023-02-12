package other;

/**
 * @author yangxiaozhuo
 * @date 2023/02/08
 */
public class Main1314 {
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int n = mat.length;
            int m = mat[0].length;
            int[][] res = new int[n][m];
            int[][] preSum = new int[n + 1][m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + mat[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res[i][j] = fun(i+ k + 1,j + k + 1, preSum) - fun(i - k,j + k + 1,preSum)
                            +  fun(i - k , j - k, preSum) - fun(i + k + 1, j - k,preSum);
                }
            }
            return res;
        }

        private int fun(int a, int b, int[][] preSum) {
            if (a < 0 || b < 0 ) {
                return 0;
            }
            if (a >= preSum.length ) {
                return fun(preSum.length - 1, b, preSum);
            }
            if (b >= preSum[0].length) {
                return fun(a, preSum[0].length - 1, preSum);
            }
            return preSum[a][b];
        }
    }
}

