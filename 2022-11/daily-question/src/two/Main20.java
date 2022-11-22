package two;

/**
 * 799. 香槟塔
 * @author yangxiaozhuo
 * @date 2022/11/20
 */
public class Main20 {
    class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            double[][] dp = new double[101][101];
            dp[0][0] = poured;
            for(int i = 0; i <= query_row; i++) {
                for(int j = 0; j <= i; j++) {
                    if(dp[i][j] > 1) {
                        double temp = dp[i][j] - 1;
                        dp[i + 1][j] += temp / 2;
                        dp[i + 1][j + 1] += temp / 2;
                        dp[i][j] = 1;
                    }
                }
            }
            return dp[query_row][query_glass];
        }
    }
}
