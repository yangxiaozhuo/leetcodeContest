import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 6240. 树上最大得分和路径
 * @author yangxiaozhuo
 * @date 2022/11/12
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{0,2},{1,4},{1,6},{2,4},{3,6},{3,7},{5,7}};
        int[] amount = new int[]{-6896,-1216,-1208,-1108,1606,-7704,-9212,-8258};
        System.out.println(solution.mostProfitablePath(ints, 4, amount));
    }
//    [[0,2],[1,4],[1,6],[2,4],[3,6],[3,7],[5,7]]
//            4
//            [-6896,-1216,-1208,-1108,1606,-7704,-9212,-8258]

    //[[0,2],[0,5],[1,3],[1,5],[2,4]]
//        4
//        [5018,8388,6224,3466,3808,3456]
//        20328
    static class Solution {
        static int res = Integer.MIN_VALUE;
        static ArrayList<Integer> bobLace = new ArrayList<>();

        public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
            Arrays.sort(edges, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            ArrayList[] lists = new ArrayList[edges.length + 1];
            for (int i = 0; i < lists.length; i++) {
                lists[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < edges.length; i++) {
                lists[edges[i][0]].add(edges[i][1]);
                lists[edges[i][1]].add(edges[i][0]);
            }
            HashMap<Integer, Integer> map = new HashMap<>();  //编号-第几次
            //找bob走的路
            bobLace = new ArrayList<>();
            bobLace.add(bob);
            findBob(lists, bob, new int[edges.length + 1]);
            //todo
            for (int i = 0; i < bobLace.size(); i++) {
                map.put(bobLace.get(i), i);
            }
            res = Integer.MIN_VALUE;
            dfs(lists, 0, map, 0, 0, amount, new int[edges.length + 1]);
            return res;
        }

        private boolean findBob(ArrayList<Integer>[] lists, int bob, int[] vis) {
            if (vis[bob] == 1) {
                return false;
            }
            if (bob == 0) {
                return true;
            }
            vis[bob] = 1;
            for (Integer i : lists[bob]) {
                bobLace.add(i);
                if (findBob(lists, i, vis)) {
                    return true;
                }
                bobLace.remove(bobLace.size() - 1);
            }
            vis[bob] = 0;
            return false;
        }

        private void dfs(ArrayList<Integer>[] lists, int nowAt, HashMap<Integer, Integer> map, int times, int val, int[] amount, int[] vis) {
            if (vis[nowAt] == 1) {
                return;
            } else {
                vis[nowAt] = 1;
            }
            if (lists[nowAt].size() == 1 && vis[lists[nowAt].get(0)] == 1) {
                if (map.getOrDefault(nowAt, Integer.MAX_VALUE) < times) {
                    res = Math.max(res, val);
                } else {
                    res = Math.max(res, val + amount[nowAt]);
                }
                return;
            }
            if (map.getOrDefault(nowAt, -1) == times) {
                val = val + amount[nowAt] / 2;
            } else if (map.getOrDefault(nowAt, Integer.MAX_VALUE) > times) {
                val = val + amount[nowAt];
            }
            for (Integer i : lists[nowAt]) {
                dfs(lists, i, map, times + 1, val, amount, vis);
            }
        }
    }
}
