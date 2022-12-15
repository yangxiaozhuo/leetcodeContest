import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2022/12/04
 */
public class Main3 {
    public static void main(String[] args) {

        int[][] ints = new int[][]{{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        Solution solution = new Solution();
        int i = solution.minScore(4, ints);
        System.out.println(i);
    }
    static class Solution {
        int res = 100000;

        public int minScore(int n, int[][] roads) {
            ArrayList<int[]>[] graph = new ArrayList[n + 1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<int[]>();
            }
            for (int i = 0; i < roads.length; i++) {
                int a = roads[i][0];
                int b = roads[i][1];
                int len = roads[i][2];
                graph[a].add(new int[]{b , len});
                graph[b].add(new int[]{a , len});
            }
            res = 100000;
            int[] vis = new int[n + 1];
            dfs(graph, vis, 1);
            return res;
        }

        private void dfs(ArrayList<int[]>[] graph, int[] vis, int o) {
            if (vis[o] == 1) {return;}
            vis[o] = 1;
            ArrayList<int[]> arrayList = graph[o];
            for (int i = 0; i < arrayList.size(); i++) {
                res = Math.min(res, arrayList.get(i)[1]);
                dfs(graph, vis, arrayList.get(i)[0]);
            }
        }
    }
}
