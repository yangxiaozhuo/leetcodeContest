import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yangxiaozhuo
 * @date 2022/12/10
 */
public class Main02 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 10, -10, -20};
        int[][] edge = new int[][]{{1, 0}, {1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}};
        Solution solution = new Solution();
        System.out.println(solution.maxStarSum(ints, edge, 2));
    }

    static class Solution {
        public int maxStarSum(int[] vals, int[][] edges, int k) {
            if (k == 0) {
                int res = vals[0];
                for (int i = 0; i < vals.length; i++) {
                    res = Math.max(res, vals[i]);
                }
                return res;
            }
            ArrayList<Integer>[] graph = new ArrayList[vals.length];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < edges.length; i++) {
                int a = edges[i][0];
                int b = edges[i][1];
                graph[a].add(b);
                graph[b].add(a);
            }
            for (int i = 0; i < graph.length; i++) {
                graph[i].sort((o1, o2) -> vals[o2] - vals[o1]);
            }
            int res = vals[0];
            for (int i = 0; i < vals.length; i++) {
                ArrayList<Integer> arr = graph[i];
                int temp = 0;
                for (int j = 0; j < k && j < arr.size(); j++) {
                    if (vals[arr.get(j)] < 0) {
                        break;
                    }
                    temp += vals[arr.get(j)];
                }
                res = Math.max(res, temp + vals[i]);
            }
            return res;
        }
    }
}
