package test4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/05/14
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{0,1},{0,2},{1,2},{3,4}};
        System.out.println(solution.countCompleteComponents(6, ints));
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] sum = new int[n];
        ArrayList<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            sum[a]++;
            sum[b]++;
            lists[a].add(b);
            lists[b].add(a);
        }
        int[] vis = new int[n];
        int index = 1;
        for (int i = 0; i < n; i++) {
            dfs(i, index, vis, lists);
            index++;
        }
        int[] tt = new int[index];
        int[] tt2 = new int[index];
        for (int i = 0; i < n; i++) {
            tt[vis[i]] += sum[i];
            tt2[vis[i]]++;
        }
        int res = 0;
        for (int i = 0; i < tt2.length; i++) {
            if (tt2[i] == 0) {
                continue;
            }
            if (fun(tt2[i]) == tt[i] / 2) {
                res++;
            }
        }
//        System.out.println(fun(1));
//        System.out.println(fun(2));
//        System.out.println(fun(3));
//        System.out.println(Arrays.toString(tt));
//        System.out.println(Arrays.toString(tt2));
//        System.out.println(Arrays.toString(vis));
        return res;
    }

    private int fun(int n) {
        int res = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            res += index;
            index++;
        }
        return res;
    }

    private void dfs(int at, int index, int[] vis, ArrayList<Integer>[] lists) {
        if (vis[at] != 0) {
            return;
        }
        vis[at] = index;
        ArrayList<Integer> list = lists[at];
        for (int i = 0; i < list.size(); i++) {
            int ne = list.get(i);
            if (vis[ne] == 0) {
                dfs(ne, index, vis, lists);
            }
        }
    }
}