package three;

/**
 * @author yangxiaozhuo
 * @date 2022/11/21
 */
public class Main21 {
    class Solution {
        double[][] dp;

        public double soupServings(int n) {
            if (n > 5000) return 1.0;
            dp = new double[n][n];
            return dfs(n, n);
        }

        private double dfs(int a, int b) {
            if (a == 0 && b != 0) {
                return 1;
            }
            if (a == 0 && b == 0) {
                return 0.5;
            }
            if (a != 0 && b == 0) {
                return 0;
            }
            if (dp[a][b] != 0) {
                return dp[a][b];
            }
            double res = 0;
            res += dfs(Math.max(0, a - 100), b);
            res += dfs(Math.max(0, a - 75), Math.max(0, b - 25));
            res += dfs(Math.max(0, a - 50), Math.max(0, b - 50));
            res += dfs(Math.max(0, a - 25), Math.max(0, b - 75));
            res = res / 4;
            dp[a][b] = res;
            return res;
        }
    }
}
