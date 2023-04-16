package text04;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/04/16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        n = 4, edges = [[0,1],[1,2],[1,3]], price = [2,2,10,6], trips = [[0,3],[2,1],[2,3]]
        int[][] ints = new int[][]{{0, 1}, {1, 2}, {1, 3}};
        int[][] int2 = new int[][]{{0, 3}, {2, 1}, {2, 3}};
        int[] t = new int[]{2, 2, 10, 6};
        System.out.println(solution.minimumTotalPrice(4, ints, t, int2));
    }
}

class Solution {
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        ArrayList<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (arr[a] == null) {
                arr[a] = new ArrayList<>();
            }
            if (arr[b] == null) {
                arr[b] = new ArrayList<>();
            }
            arr[a].add(b);
            arr[b].add(a);
        }
        ArrayList<int[]> roads = new ArrayList<>();
        for (int i = 0; i < trips.length; i++) {
            int start = trips[i][0];
            int end = trips[i][1];
            int[] temp = road(arr, start, end);
            roads.add(temp);
        }
        int[] num = new int[n];
        for (int i = 0; i < roads.size(); i++) {
            int[] ints = roads.get(i);
            for (int in : ints) {
                num[in]++;
            }
        }
        int[] temp = jisuan(0, num, price, arr, -1);
        return Math.min(temp[0], temp[1]);
    }

    private int[] jisuan(int at, int[] num, int[] price, ArrayList<Integer>[] arr, int last) {
        int[] temp = new int[2];
        for (int i = 0; i < arr[at].size(); i++) {
            int next = arr[at].get(i);
            // 打折 和 不打折
            if (next == last) {
                continue;
            }
            int[] jisuan = jisuan(next, num, price, arr, at);
            temp[0] += jisuan[1];
            temp[1] += Math.min(jisuan[0], jisuan[1]);
        }
        temp[0] += num[at] * price[at] / 2;
        temp[1] += num[at] * price[at];
        return temp;
    }

    private int[] road(ArrayList<Integer>[] arr, int start, int end) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(res, arr, start, end, new int[arr.length]);
        int[] temp = new int[res.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = res.get(i);
        }
        return temp;
    }

    private boolean dfs(ArrayList<Integer> res, ArrayList<Integer>[] arr, int at, int end, int[] vis) {
        if (vis[at] == 1) {
            return false;
        }
        vis[at] = 1;
        res.add(at);
        if (at == end) {
            return true;
        }
        ArrayList<Integer> arrayList = arr[at];
        for (int i = 0; i < arrayList.size(); i++) {
            //可以去的点
            int next = arrayList.get(i);
            if (vis[next] != 1) {
                boolean t = dfs(res, arr, next, end, vis);
                if (t) {
                    return true;
                } else {
                    res.remove(res.size() - 1);
                }
            }
        }
        return false;
    }
}