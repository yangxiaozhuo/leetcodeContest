import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 没做出来
 * 
 * @author yangxiaozhuo
 * @date 2022/11/20
 */
public class Main03 {
    public static void main(String[] args) {
//        [[0,1],[0,2],[1,3],[1,4]]
//        5 预期4
//        int[][] ints = new int[][]{{0,1}, {0, 2}, {1, 3}, {1, 4}};
        int[][] ints = new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        Solution solution = new Solution();
        System.out.println(solution.minimumFuelCost(ints, 2));
    }

    static class Solution {
        PriorityQueue<int[]> queue;
        ArrayList<Integer>[] graph;
        HashMap<Integer, Integer> map;
        long res = 0;

        public long minimumFuelCost(int[][] roads, int seats) {
            queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            map = new HashMap<>();
            res = 0;
            int n = roads.length + 1; //城市的数量
            graph = buildGraph(n, roads);
            int[] vis = new int[n];
            ArrayList<Integer> start = new ArrayList<>();
            findStart(start, new int[n], 0, 0);
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();  //序号 + 深度
                vis[poll[0]] = 1;
                res += poll[1];
                int size = seats;
                ArrayList<Integer> arrayList = graph[poll[0]];
                while (size > 0 && !queue.isEmpty()) {
                    boolean flag = true;
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (vis[arrayList.get(i)] == 0 && map.get(arrayList.get(i)) < poll[1]) {
                            flag = false;
                            break;
                        }
                        if (arrayList.get(i) == 0) {
                            size = 0;
                        }
                    }
                    if (!flag) {
                        size--;
                    }
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (map.get(arrayList.get(i)) < poll[1]) {
                            int[] ints = {arrayList.get(i), map.get(arrayList.get(i))};
                             for (int[] a : queue) {
                                 if (a[0] == ints[0] && a[1] == ints[1]) {
                                     queue.remove(a);
                                     break;
                                 }
                             }
                            arrayList = graph[arrayList.get(i)];
                            break;
                        }
                    }
                }
            }
            return res;
        }


        private void findStart(ArrayList<Integer> start, int[] vis, int at, int depth) {
            queue.add(new int[]{at, depth});
            map.put(at, depth);
            vis[at] = 1;
            ArrayList<Integer> arrayList = graph[at];
            boolean flag = true;
            for (int i = 0; i < arrayList.size(); i++) {
                if (vis[arrayList.get(i)] != 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                start.add(at);
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (vis[arrayList.get(i)] != 1) {
                    findStart(start, vis, arrayList.get(i), depth + 1);
                }
            }
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
