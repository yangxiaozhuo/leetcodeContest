import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 2477. 到达首都的最少油耗
 * 没做出来,补题过了
 * 
 * @author yangxiaozhuo
 * @date 2022/11/20
 */
public class Main03 {
    public static void main(String[] args) {
//        [[0,1],[0,2],[1,3],[1,4]]
//        5 预期4
        int[][] ints = new int[][]{{0,1}, {0, 2}, {1, 3}, {1, 4}};
//        int[][] ints = new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        Solution solution = new Solution();
        System.out.println(solution.minimumFuelCost(ints, 5));
    }

    static class Solution {
        ArrayList<Integer>[] graph;
        long res = 0;

        public long minimumFuelCost(int[][] roads, int seats) {
            res = 0;
            int n = roads.length + 1; //城市的数量
            graph = buildGraph(n, roads);
            ArrayList<Integer> start = graph[0];
            for (int i = 0; i < start.size(); i++) {
               fun(0, graph[0].get(i),seats);
            }
            return res;
        }

        //计算的是，把包括nextNode和他之后的所有节点，全部运到nextNode节点后，运送到pnode需要耗费的油费
        private long fun(int pnode, Integer nextNode, int seats) {
            int nodeNum = 1; //计算nextNode之后有多少个节点，包括自己
            ArrayList<Integer> arrayList = graph[nextNode];
            for (int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i) != pnode) {
                    nodeNum += fun(nextNode, arrayList.get(i),seats);
                }
            }
            res = res + (nodeNum + seats - 1) / seats;
            return nodeNum;
        }


        private ArrayList<Integer>[] buildGraph(int n, int[][] roads) {
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < roads.length; i++) {
                int a = roads[i][0];
                int b = roads[i][1];
                graph[a].add(b);
                graph[b].add(a);
            }
            return graph;
        }
    }
}
