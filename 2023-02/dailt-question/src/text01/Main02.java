package text01;

import java.util.Arrays;

/**
 * 1129. 颜色交替的最短路径
 *
 * @author yangxiaozhuo
 * @date 2023/02/02
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] red = {{0,1},{1,2},{2,3},{3,4}};
        int[][] blue = {{1,2},{2,3},{3,1}};
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(5, red, blue)));
    }

    static class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            int[] res = new int[n];
            Arrays.fill(res, -1);
            res[0] = 0;
            int[][] graph = new int[n][n];
            int[][] dp = new int[n][2]; //red1 blue 2
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            dp[0][0] = 0;
            dp[0][1] = 0;
            for (int i = 0; i < redEdges.length; i++) {
                int a = redEdges[i][0];
                int b = redEdges[i][1];
                graph[a][b] = 1;
            }
            for (int i = 0; i < blueEdges.length; i++) {
                int a = blueEdges[i][0];
                int b = blueEdges[i][1];
                if (graph[a][b] == 1) {
                    graph[a][b] = 3;
                } else {
                    graph[a][b] = 2;
                }
            }
            dfs(0, graph, dp);
            for (int i = 0; i < n; i++) {
                if (dp[i][0] == -1) {
                    res[i] = dp[i][1];
                    continue;
                }
                if (dp[i][1] == -1) {
                    res[i] = dp[i][0];
                    continue;
                }
                res[i] = Math.min(dp[i][0],dp[i][1]);
            }
            return res;
        }

        private void dfs(int at, int[][] graph, int[][] dp) {
            for (int i = 0; i < graph.length; i++) {
                //从at到i
                if (graph[at][i] == 0) { // 没路
                    continue;
                } else if (graph[at][i] == 1) {
                    //有红色路
                    if (dp[at][1] != -1) {
                        if (dp[i][0] == -1 || dp[i][0] > dp[at][1] + 1) {
                            dp[i][0] = dp[at][1] + 1;
                            dfs(i,graph,dp);
                        }
                    }
                } else if (graph[at][i] == 2) {
                    //有蓝色路
                    if (dp[at][0] != -1) {
                        if (dp[i][1] == -1 || dp[i][1] > dp[at][0] + 1) {
                            dp[i][1] = dp[at][0] + 1;
                            dfs(i,graph,dp);
                        }
                    }
                } else {
                    if (dp[at][1] != -1) {
                        if (dp[i][0] == -1 || dp[i][0] > dp[at][1] + 1) {
                            dp[i][0] = dp[at][1] + 1;
                            dfs(i,graph,dp);
                        }
                    }
                    if (dp[at][0] != -1) {
                        if (dp[i][1] == -1 || dp[i][1] > dp[at][0] + 1) {
                            dp[i][1] = dp[at][0] + 1;
                            dfs(i,graph,dp);
                        }
                    }
                }
            }
        }
    }
}
