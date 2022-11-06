/**
 * 2435. 矩阵中和能被 K 整除的路径
 *
 * @author yangxiaozhuo
 * @date 2022/10/09
 *
 * 给你一个下标从 0开始的m x n整数矩阵grid和一个整数k。你从起点(0, 0)出发，每一步只能往 下或者往 右，你想要到达终点(m - 1, n - 1)。
 * 请你返回路径和能被 k整除的路径数目，由于答案可能很大，返回答案对109 + 7取余的结果。
 * <p>
 * 示例 1：
 * 输入：grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
 * 输出：2
 * 解释：有两条路径满足路径上元素的和能被 k 整除。
 * 第一条路径为上图中用红色标注的路径，和为 5 + 2 + 4 + 5 + 2 = 18 ，能被 3 整除。
 * 第二条路径为上图中用蓝色标注的路径，和为 5 + 3 + 0 + 5 + 2 = 15 ，能被 3 整除。
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{5, 2, 4}, {3, 0, 5}, {0, 7, 2}};
        System.out.println(solution.numberOfPaths(grid, 3));
    }

    static class Solution {
        public int numberOfPaths(int[][] grid, int k) {
            int MOD = 1000000007;
            int[][][] dp = new int[grid.length + 1][grid[0].length + 1][k];
            int n = grid.length;
            int m = grid[0].length;
            dp[1][1][grid[0][0] % k] = 1;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    for (int l = 0; l < k; l++) {
                        dp[i][j][(l + grid[i - 1][j - 1]) % k] = (dp[i][j][(l + grid[i - 1][j - 1]) % k] % MOD + (dp[i - 1][j][l] + dp[i][j - 1][l]) % MOD) % MOD;
                    }
                }
            }
            return dp[n][m][0] % MOD;
        }
    }
}
