package two;

import java.util.HashSet;

/**
 * 827. 最大人工岛
 *
 * @author yangxiaozhuo
 * @date 2022/09/18
 */
public class Main18 {
    class Solution {
        int[][] num;

        public int largestIsland(int[][] grid) {
            num = new int[grid.length][grid[0].length];
            int index = 1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        num[i][j] = -1;
                    }
                    if (num[i][j] == 0) {
                        dsf(i, j, index, grid);
                        index++;
                    }
                }
            }
            int[] gridare = new int[index - 1];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (num[i][j] != -1) {
                        gridare[num[i][j] - 1]++;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < gridare.length; i++) {
                res = Math.max(res, gridare[i]);
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (num[i][j] == -1) {
                        res = Math.max(res, fun(i, j, gridare) + 1);
                    }
                }
            }
            return res;
        }

        public int fun(int i, int j, int[] gridare) {
            HashSet<Integer> set = new HashSet<>();
            if (i > 0 && num[i - 1][j] != -1) set.add(num[i - 1][j]);
            if (j > 0 && num[i][j - 1] != -1) set.add(num[i][j - 1]);
            if (i < num.length - 1 && num[i + 1][j] != -1) set.add(num[i + 1][j]);
            if (j < num[0].length - 1 && num[i][j + 1] != -1) set.add(num[i][j + 1]);
            int res = 0;
            for (Integer a : set) {
                res = res + gridare[a - 1];
            }
            return res;
        }

        public void dsf(int i, int j, int index, int[][] grid) {
            if (num[i][j] != 0) return;
            if (grid[i][j] == 0) return;
            num[i][j] = index;
            if (i > 0) dsf(i - 1, j, index, grid);
            if (j > 0) dsf(i, j - 1, index, grid);
            if (i < grid.length - 1) dsf(i + 1, j, index, grid);
            if (j < grid[0].length - 1) dsf(i, j + 1, index, grid);
        }
    }
}
