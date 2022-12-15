import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * @author yangxiaozhuo
 * @date 2022/12/04
 */
public class Main4 {
    public static void main(String[] args) {
//        92  答案 57
//         [[67,29],[13,29],[77,29],[36,29],[82,29],[54,29],[57,29],[53,29],[68,29],[26,29],[21,29],[46,29],[41,29],[45,29],[56,29],[88,29],[2,29],[7,29],[5,29],[16,29],[37,29],[50,29],[79,29],[91,29],[48,29],[87,29],[25,29],[80,29],[71,29],[9,29],[78,29],[33,29],[4,29],[44,29],[72,29],[65,29],[61,29]]
//        int[][] ints = new int[][]{{1,2},{1,4},{1,5},{2,6},{2,3},{4,6}};
//        int[][] ints = new int[][]    {{67,29},{13,29},{77,29},{36,29},{82,29},{54,29},{57,29},{53,29},{68,29},{26,29},{21,29},{46,29},{41,29},{45,29},{56,29},{88,29},{2,29},{7,29},{5,29},{16,29},{37,29},{50,29},{79,29},{91,29},{48,29},{87,29},{25,29},{80,29},{71,29},{9,29},{78,29},{33,29},{4,29},{44,29},{72,29},{65,29},{61,29}};
//        int[][] ints = new int[][]    {{9,16},{8,3},{20,21},{12,16},{14,3},{7,21},{22,3},{22,18},{11,16},{25,4},{2,4},{14,21},{23,3},{17,3},{2,16},{24,16},{13,4},{10,21},{7,4},{9,18},{14,18},{14,4},{14,16},{1,3},{25,18},{17,4},{1,16},{23,4},{2,21},{5,16},{24,18},{20,18},{19,16},{24,21},{9,3},{24,3},{19,18},{25,16},{19,21},{6,3},{26,18},{5,21},{20,16},{2,3},{10,18},{26,16},{8,4},{11,21},{23,16},{13,16},{25,3},{7,18},{19,3},{20,4},{26,3},{23,18},{15,18},{17,18},{10,16},{26,21},{23,21},{7,16},{8,18},{10,4},{24,4},{7,3},{11,18},{9,4},{26,4},{13,21},{22,16},{22,21},{20,3},{6,18},{9,21},{10,3},{22,4},{1,18},{25,21},{11,4},{1,21},{15,3},{1,4},{15,16},{2,18},{13,3},{8,21},{13,18},{11,3},{15,21},{8,16},{17,16},{15,4},{12,3},{6,4},{17,21},{5,18},{6,16},{6,21},{12,4},{19,4},{5,3},{12,21},{5,4}};
   //26  预计4
        int[][] ints = new int[][]    {    {1,9},{30,27},{21,9},{2,10},{16,28},{1,27},{20,24},{22,24},{30,6},{30,19},{1,19},{30,11},{16,6},{16,29},{2,29},{2,23},{16,24},{1,25},{1,17},{16,23},{30,26},{16,12},{1,14},{13,23},{13,14},{2,19},{22,6},{30,3},{30,18},{20,8},{13,24},{20,9},{20,14},{13,28},{13,10},{2,8},{16,7},{16,10},{21,5},{20,15},{20,11},{2,26},{21,3},{22,10},{16,8},{2,17}};

        Solution solution = new Solution();
        int i = solution.magnificentSets(30, ints);
        System.out.println(i);
    }
    static class Solution {
        int res = 0;
        int max = 0;
        public int magnificentSets(int n, int[][] edges) {
            res = 0;
            ArrayList<Integer>[] graph = buildGrapg(n, edges);
            int[] vis = new int[n + 1];
            for (int i = 1; i < vis.length; i++) {
//                if (vis[i] == 0 && graph[i].size() <= 1) {
                    max = 0;
                    if(!dfs(graph, i, vis, 1)) {
                        return -1;
                    }
                    res = res + max;
//                }
            }
//            for (int i = 1; i < vis.length; i++) {
//                if (vis[i] == 0 && graph[i].size() == 2) {
//                    max = 0;
//                    if(!dfs(graph, i, vis, 1)) {
//                        return -1;
//                    }
//                    res = res + max;
//                }
//            }
//            for (int i = 1; i < vis.length; i++) {
//                if (vis[i] == 0 ) {
////                    return -1;
//                }
//            }
//            int res = 0;
//            for (int i = 1; i < vis.length; i++) {
//                res = Math.max(res , vis[i]);
//            }
            return res;
        }

        private boolean dfs(ArrayList<Integer>[] graph, int start, int[] vis, int depth) {
            if(vis[start] != 0) {
                return true;
            }
            if (depth <= 0) {
                return false;
            }
            vis[start] = depth;
            ArrayList<Integer> arrayList = graph[start];
            for (int i =0; i < arrayList.size(); i++) {
                Integer integer = arrayList.get(i);
                if (vis[integer] == 0) {
                    boolean dfs = dfs(graph, integer, vis, depth + 1);
                    if (!dfs) {
                        dfs = dfs(graph, integer, vis, depth - 1);
                        if (!dfs) {
                            vis[start] = 0;
                            return false;
                        }
                    }
                } else {
                    if (Math.abs(vis[integer] - depth) != 1) {
                        vis[start] = 0;
                        return false;
                    }
                }
            }
            if (max < depth) {
                max = depth;
            }
            return true;
        }

        private boolean check(int[] vis) {
            for (int i = 1; i < vis.length; i++) {
                if (vis[i] == 0) {
                    return true;
                }
            }
            return false;
        }

        private ArrayList<Integer>[] buildGrapg(int n, int[][] edges) {
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < edges.length; i++) {
                int a = edges[i][0];
                int b = edges[i][1];
                graph[a].add(b);
                graph[b].add(a);
            }
            return graph;
        }
    }
}
