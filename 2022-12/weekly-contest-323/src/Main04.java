import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2022/12/11
 */
public class Main04 {
    public static void main(String[] args) {
//        [1,2,3],[2,5,7],[3,5,1]
//        int[][] ints = new int[][]{{1,2,3},{2,5,7},{3,5,1}};
//        int[] ints1 = new int[]{5,6,2};
        int[][] ints = new int[100][100];
        for (int i = 0; i < ints.length; i++) {
            Arrays.fill(ints[i],4);
        }
        int[] ints1 = new int[2];
        Arrays.fill(ints1,6);

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxPoints(ints, ints1)));
    }
    static class Solution {
        public int[] maxPoints(int[][] grid, int[] queries) {
            int[] dp = new int[1000010];
            int[][] vis = new int[grid.length][grid[0].length];
            ArrayList<int[]> arrayList = new ArrayList<>();
            arrayList.add(new int[]{0,0,-1});
            bfs(grid, vis, arrayList);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    dp[vis[i][j]] = dp[vis[i][j]] + 1;
                }
            }
            int[] sum = new int[dp.length + 1];
            for (int i = 0; i < dp.length; i++) {
                sum[i + 1] = sum[i] + dp[i];
            }
            for (int i = 0; i < queries.length; i++) {
                queries[i] = sum[queries[i]];
            }
            return queries;
        }
        private void bfs(int[][] grid, int[][] vis,ArrayList<int[]> arr) {
            while (!arr.isEmpty()) {
                ArrayList<int[]> arrayList = new ArrayList<>();
                for (int k = 0; k < arr.size(); k++) {
                    int[] ints = arr.get(k);
                    int i = ints[0];
                    int j = ints[1];
                    int max = ints[2];
                    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                        continue;
                    }
                    max = Math.max(grid[i][j],max);
                    if (vis[i][j] != 0 && vis[i][j] <= max) {
                        continue;
                    }
                    vis[i][j] = max;
                    arrayList.add(new int[]{ i + 1, j,max});
                    arrayList.add(new int[]{ i, j + 1,max});
                    arrayList.add(new int[]{ i - 1, j,max});
                    arrayList.add(new int[]{ i, j - 1,max});
                }
                arr = arrayList;
            }
        }
        private void dfs(int[][] grid, int i, int j, int max, int[][] vis) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            max = Math.max(max, grid[i][j]);
            if (vis[i][j] != 0 && vis[i][j] <= max) {
                return;
            }
            vis[i][j] = max;
            dfs(grid, i + 1, j, max, vis);
            dfs(grid, i, j + 1, max, vis);
            dfs(grid, i - 1, j, max, vis);
            dfs(grid, i, j - 1, max, vis);
        }
    }
}
