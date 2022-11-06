package three;

import java.util.ArrayDeque;

/**
 * 34. 最短的桥
 *
 * @author yangxiaozhuo
 * @date 2022/10/25
 */
public class Main25 {
    class Solution {
        int[][] dirct = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int[][] vis;
        ArrayDeque<int[]> arr;
        int res = 0;

        public int shortestBridge(int[][] grid) {
            res = 0;
            vis = new int[grid.length][grid[0].length];
            arr = new ArrayDeque<>();
            int[] local = find(grid);
            dfs(grid, local[0], local[1]);
            local = find(grid);
            dfs2(grid, local[0], local[1]);
            bfs(arr, grid);
            return res - 1;
        }

        private void bfs(ArrayDeque<int[]> arr, int[][] grid) {
            while (!arr.isEmpty()) {
                res++;
                int size = arr.size();
                for (int i = 0; i < size; i++) {
                    int[] first = arr.removeFirst();
                    if (add(first, grid)) {
                        return;
                    }
                }
            }
        }

        private boolean add(int[] first, int[][] grid) {
            for (int k = 0; k < dirct.length; k++) {
                int i = first[0] + dirct[k][0];
                int j = first[1] + dirct[k][1];
                if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 3) {
                    continue;
                } else if (grid[i][j] == 2) {
                    return true;
                } else if (grid[i][j] == 0) {
                    grid[i][j] = 3;
                    arr.addLast(new int[]{i, j});
                }
            }
            return false;
        }

        private void dfs2(int[][] grid, int i, int j) {
            if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0 || grid[i][j] == 3) {
                return;
            }
            if (grid[i][j] == 1) {
                grid[i][j] = 3;
                arr.add(new int[]{i, j});
            }
            for (int k = 0; k < dirct.length; k++) {
                dfs2(grid, i + dirct[k][0], j + dirct[k][1]);
            }
        }

        private void dfs(int[][] grid, int i, int j) {
            if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) {
                return;
            }
            if (grid[i][j] == 1) {
                grid[i][j] = 2;
            }
            for (int k = 0; k < dirct.length; k++) {
                dfs(grid, i + dirct[k][0], j + dirct[k][1]);
            }
        }

        private int[] find(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{0, 0};
        }
    }
}
