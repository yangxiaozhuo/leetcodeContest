import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/01/15
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{0,1},{1,2},{1,3},{3,4},{3,5}};
        int[] ints1 = new int[]{9,8,7,6,10,5};
        System.out.println(solution.maxOutput(6, ints, ints1));
//        [[0,1],[1,2],[1,3],[3,4],[3,5]], price = [9,8,7,6,10,5]
//        [[0,1],[1,2],[1,3],[3,4],[3,5]], price = [9,8,7,6,10,5]
    }

    static class Solution {
        public long maxOutput(int n, int[][] edges, int[] price) {
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < edges.length; i++) {
                int a = edges[i][0];
                int b = edges[i][1];
                graph[a].add(b);
                graph[b].add(a);
            }
            int[][] max = new int[n][2];
            int[] vis = new int[n];
            fun(graph, max, price, vis, 0, 0);
            int res = 0;
            for (int i = 0; i < max.length; i++) {
                res = Math.max(res,max[i][0] + max[i][1] - price[i]);
            }
            return res;
        }

        private int fun(ArrayList<Integer>[] graph, int[][] max, int[] price, int[] vis, int haveValue, int at) {
            if (graph[at].size() == 1 && vis[graph[at].get(0)] == 1) {
                max[at][0] = haveValue + price[at];
                return price[at];
            }
            vis[at] = 1;
            ArrayList<Integer> nextNode = graph[at];
            for (int i = 0; i < nextNode.size(); i++) {
                if (vis[nextNode.get(i)] == 0) {
                    int temp = fun(graph, max, price, vis, haveValue + price[at], nextNode.get(i));
                    if (temp > max[at][1]) {
                        max[at][1] = temp;
                    }
                    if (max[at][0] < max[at][1]) {
                        int t = max[at][0];
                        max[at][0] = max[at][1];
                        max[at][1] = t;
                    }
                }
            }
//            if (haveValue > max[at][1]) {
//                max[at][1] = haveValue;
//            }
//            if (max[at][0] < max[at][1]) {
//                int t = max[at][0];
//                max[at][0] = max[at][1];
//                max[at][1] = t;
//            }
            return max[at][0] + price[at];
        }
    }
}
