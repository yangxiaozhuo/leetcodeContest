/**
 * 2428. 沙漏的最大总和
 *
 * @author yangxiaozhuo
 * @date 2022/10/02
 * 给你一个大小为 m x n 的整数矩阵 grid 。
 * 按以下形式将矩阵的一部分定义为一个 沙漏 ：
 * 返回沙漏中元素的 最大 总和。
 * 注意：沙漏无法旋转且必须整个包含在矩阵中。
 * <p>
 * 示例 1：
 * 输入：grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
 * 输出：30
 * 解释：上图中的单元格表示元素总和最大的沙漏：6 + 2 + 1 + 2 + 9 + 2 + 8 = 30 。
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{6, 2, 1, 3}, {4, 2, 1, 5}, {9, 2, 8, 7}, {4, 1, 2, 9}};
        System.out.println(solution.maxSum(grid));
    }

    static class Solution {
        public int maxSum(int[][] grid) {
            int res = 0;
            for (int i = 0; i < grid.length - 2; i++) {
                for (int j = 0; j < grid[0].length - 2; j++) {
                    res = Math.max(res, fun(grid, i, j));
                }
            }
            return res;
        }

        private int fun(int[][] grid, int i, int j) {
            return grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1]
                    + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        }
    }
}
