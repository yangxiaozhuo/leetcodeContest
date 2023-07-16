package test3;

/**
 * @author yangxiaozhuo
 * @date 2023/05/14
 */
public class Main {
}

class Solution {
    public int maxMoves(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][dp[0].length - 1] = 1;
//        }
        for (int j = dp[0].length - 2; j >= 0; j--) {
            for (int i = 0; i < dp.length; i++) {
                if (i > 0 && grid[i][j] < grid[i - 1][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + 1);
                }
                if (i < dp.length - 1 && grid[i][j] < grid[i + 1][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1] + 1);
                }
                if (grid[i][j] < grid[i][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        int max = dp[0][0];
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i][0], max);
        }
        return max;
    }
}