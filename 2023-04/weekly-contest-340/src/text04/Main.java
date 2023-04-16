package text04;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/04/09
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}};
        System.out.println(solution.minimumVisitedCells(ints));
    }
}

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = -1;
            }
        }
        res[0][0] = 1;
        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(new int[]{0, 0});
        int depth = 1;
        while (!arrayList.isEmpty()) {
            ArrayList<int[]> temp = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                int[] ints = arrayList.get(i);
                int a = ints[0];
                int b = ints[1];
                int t = grid[a][b];
                for (int j = 1; j <= t; j++) {
                    if (b + j < res[0].length) {
                        if (res[a][b + j] == -1 || res[a][b + j] > depth + 1) {
                            res[a][b + j] = depth + 1;
                            temp.add(new int[]{a, b + j});
                        }
                    }
                    if (a + j < res.length) {
                        if (res[a + j][b] == -1 || res[a + j][b] > depth + 1) {
                            res[a + j][b] = depth + 1;
                            temp.add(new int[]{a + j, b});
                        }
                    }
                }
            }
            if (res[res.length - 1][res[0].length - 1] != -1) {
                return res[res.length - 1][res[0].length - 1];
            }
            arrayList = temp;
            depth++;
        }
//        dfs(grid, res, 0, 0);
        return res[res.length - 1][res[0].length - 1];
    }

    private void dfs(int[][] grid, int[][] res, int a, int b) {
        int t = grid[a][b];
        int have = res[a][b];
        for (int i = 1; i <= t; i++) {
            if (b + i < res[0].length) {
                if (res[a][b + i] == -1 || res[a][b + i] > have + 1) {
                    res[a][b + i] = have + 1;
                    dfs(grid, res, a, b + i);
                }
            }
            if (a + i < res.length) {
                if (res[a + i][b] == -1 || res[a + i][b] > have + 1) {
                    res[a + i][b] = have + 1;
                    dfs(grid, res, a + i, b);
                }
            }
        }
    }
}