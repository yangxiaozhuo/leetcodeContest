package two;

import java.util.ArrayList;

/**
 * 886. 可能的二分法
 * @author yangxiaozhuo
 * @date 2022/10/16
 */
public class Main16 {
    class Solution {
        public boolean possibleBipartition(int n, int[][] dislikes) {
            if (dislikes.length == 0) return true;
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < dislikes.length; i++) {
                graph[dislikes[i][0] - 1].add(dislikes[i][1] - 1);
                graph[dislikes[i][1] - 1].add(dislikes[i][0] - 1);
            }
            int[] vis = new int[n];
            for (int i = 0; i < vis.length; i++) {
                if (vis[i] == 0 && !dfs(graph, vis, i, 1)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(ArrayList<Integer>[] graph, int[] vis, int index, int flag) {
            vis[index] = flag;
            ArrayList<Integer> arrayList = graph[index];
            for (int i = 0; i < arrayList.size(); i++) {
                Integer integer = arrayList.get(i);
                if (vis[integer] != 0 && vis[integer] == flag) {
                    return false;
                }
                if (vis[integer] == 0 && !dfs(graph, vis, integer, 3 - flag)) {
                    return false;
                }
            }
            return true;
        }
    }
}
