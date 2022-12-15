package two;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1697. 检查边长度限制的路径是否存在  不会
 *
 * @author yangxiaozhuo
 * @date 2022/12/14
 */
public class Main14 {
    public static void main(String[] args) {
//        输入：n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
//        输出：[false,true]
        Solution solution = new Solution();
        int[][] ints = new int[][]{{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}};
        int[][] ints1 = new int[][]{{0, 1, 2}, {0, 2, 5}};
        System.out.println(Arrays.toString(solution.distanceLimitedPathsExist(3, ints, ints1)));

    }

    static class Solution {
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            HashMap<Integer, Integer>[] graph = buileGraph(n, edgeList);
            return null;
        }

        private HashMap<Integer, Integer>[] buileGraph(int n, int[][] edgeList) {
            HashMap<Integer, Integer>[] graph = new HashMap[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new HashMap<>();
            }
            for (int i = 0; i < edgeList.length; i++) {
                int a = edgeList[i][0];
                int b = edgeList[i][1];
                int dis = edgeList[i][2];
                Integer orDefault = graph[a].getOrDefault(b, Integer.MAX_VALUE);
                if (orDefault > dis) {
                    graph[a].put(b, dis);
                }
                orDefault = graph[b].getOrDefault(a, Integer.MAX_VALUE);
                if (orDefault > dis) {
                    graph[b].put(a, dis);
                }
            }
            return graph;
        }
    }
}
