package text04;

import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] ints = new int[][]{{1, 1, 1, 0, 0}, {1, 0, 1, 0, 0}, {1, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {0, 0, 1, 1, 1}};
        int[][] ints = new int[][]{{1, 1, 1, 1}};
//        [[1,1,1],[1,0,0],[1,1,1]]
//        int[][] ints = new int[][]{{1, 1, 1}, {1, 0, 0}, {1, 1, 1,}};
        System.out.println(solution.isPossibleToCutPath(ints));
    }
}
//[[1,1,1,0,0],[1,0,1,0,0],[1,1,1,1,1],[0,0,1,1,1],[0,0,1,1,1]]
//true

class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dfs(grid, n - 1, m - 1);
        HashSet<String> set = new HashSet<>();
        dfs1(grid, 0, 0, set);
        return dfs2(grid, 0, 0, set);
    }

    private boolean dfs2(int[][] grid, int i, int j, HashSet<String> set) {
        if (set.contains(i + "," + j)) {
            if (i != 0 || j != 0) {
                return true;
            }
            if (i != grid.length - 1 || j != grid[0].length - 1) {
                return true;
            }
        }
        if (j == grid[0].length - 1 || grid[i][j + 1] != 3) {
            return dfs2(grid, i + 1, j, set);
        } else {
            return dfs2(grid, i, j + 1, set);
        }
    }

    private void dfs1(int[][] grid, int i, int j, HashSet<String> set) {
        set.add(i + "," + j);
        if (i == grid.length - 1 || grid[i + 1][j] != 3) {
            dfs1(grid, i, j + 1, set);
        } else {
            dfs1(grid, i + 1, j, set);
        }
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 3;
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

}