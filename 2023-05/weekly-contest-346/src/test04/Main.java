package test04;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/05/21
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        5
//[[1,4,1],[2,4,-1],[3,0,2],[0,4,-1],[1,3,10],[1,0,10]]
//0
//2
//15
//        System.out.println(Arrays.deepToString(solution.modifiedGraphEdges(5, new int[][]{{4, 1, -1}, {2, 0, -1}, {0, 3, -1}, {4, 3, -1}}, 0, 1, 5)));
//        System.out.println(Arrays.deepToString(solution.modifiedGraphEdges(4, new int[][]{{1, 0, 4}, {1, 2, 3}, {2, 3, 5}, {0, 3, -1}}, 0, 2, 6)));x
//        System.out.println(Arrays.deepToString(solution.modifiedGraphEdges(4, new int[][]{{0,1,-1}, {1,2,-1}, {3,1,-1}, {3,0,2},{0,2,5}}, 2, 3, 8)));
        System.out.println(Arrays.deepToString(solution.modifiedGraphEdges(5, new int[][]{{1,4,1}, {2,4,-1},{3,0,2},{0,4,-1},{1,3,10},{1,0,10}}, 0, 2, 15)));
    }
}

class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        ArrayList<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        int[][] value = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];
            arr[a].add(b);
            arr[b].add(a);
            value[a][b] = c;
            value[b][a] = c;
        }
        int[][] fun = fun(arr, value, n, source, destination, target);
        if (fun.length == 0) {
            return new int[0][];
        }
        for (int i = 0; i < fun.length; i++) {
            int a = fun[i][0];
            int b = fun[i][1];
            int c = fun[i][2];
            value[a][b] = c;
            value[b][a] = c;
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            edges[i][2] = value[a][b];
            if (edges[i][2] == -1) {
                edges[i][2] = 1;
            }
        }
        return edges;
    }

    private int[][] fun(ArrayList<Integer>[] arr, int[][] value, int n, int source, int destination, int target) {
        ArrayList<Integer> arrayList = arr[source];
        for (int i = 0; i < arrayList.size(); i++) {
            int[] vis = new int[n];
            vis[source] = 1;
            int start = arrayList.get(i);
            ArrayList<Result> results = dfs(arr, value, n, vis, start, destination);
            for (int m = 0; m < results.size(); m++) {
                Result temp = results.get(m);
                if (!temp.isTarget) {
                    continue;
                }
                if ((value[source][start] == -1)) {
                    temp.haveNav++;
                }
                int val = temp.val + value[source][start];
                if (temp.haveNav == 0 && val < target) {
                    return new int[0][];
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            int[] vis = new int[n];
            vis[source] = 1;
            int start = arrayList.get(i);
            ArrayList<Result> results = dfs(arr, value, n, vis, start, destination);
            for (int m = 0; m < results.size(); m++) {
                Result temp = results.get(m);
                if (!temp.isTarget) {
                    continue;
                }
                if ((value[source][start] == -1)) {
                    temp.haveNav++;
                }
                int val = temp.val + value[source][start];
                if (val > target) {
                    continue;
                }
                if (val == target) {
                    int[][] res = new int[temp.rode.size() + 1][3];
                    res[0][0] = source;
                    res[0][1] = start;
                    res[0][2] = value[source][start];
                    for (int j = 0; j < temp.rode.size(); j++) {
                        res[j + 1][0] = temp.rode.get(j)[0];
                        res[j + 1][1] = temp.rode.get(j)[1];
                        res[j + 1][2] = value[res[j + 1][0]][res[j + 1][1]];
                    }
                    return res;
                }
                int div = target - val;
                if (temp.haveNav * 2 > div) {
                    continue;
                }
                //todo
                if (temp.haveNav > 0) {
                    int[][] res = new int[temp.rode.size() + 1][3];
                    res[0][0] = source;
                    res[0][1] = start;
                    if (value[source][start] == -1) {
                        if (temp.haveNav == 1) {
                            res[0][2] = div - 1;
                            div = 0;
                        } else {
                            res[0][2] = 1;
                            div -= 2;
                        }
                        temp.haveNav--;
                    } else {
                        res[0][2] = value[source][start];
                    }
                    for (int j = 0; j < temp.rode.size(); j++) {
                        res[j + 1][0] = temp.rode.get(j)[0];
                        res[j + 1][1] = temp.rode.get(j)[1];
                        if (value[res[j + 1][0]][res[j + 1][1]] == -1) {
                            if (temp.haveNav == 1) {
                                res[j + 1][2] = div - 1;
                                div = 0;
                            } else {
                                res[j + 1][2] = 1;
                                div -= 2;
                            }
                            temp.haveNav--;
                        } else {
                            res[j + 1][2] = value[res[j + 1][0]][res[j + 1][1]];
                        }
                    }
                    return res;
                }
            }
        }
        return new int[0][];
    }

    //返回这条路能否走到target，返回路径，返回路径值
    private ArrayList<Result> dfs(ArrayList<Integer>[] arr, int[][] value, int n, int[] vis, int at, int target) {
        ArrayList<Result> res = new ArrayList<>();
        if (vis[at] == 1) {
            return res;
        }
        if (at == target) {
            res.add(new Result(true, 0, 0, new ArrayList<>()));
            return res;
        }
        vis[at] = 1;
        ArrayList<Integer> arrayList = arr[at];
        for (int i = 0; i < arrayList.size(); i++) {
            Integer next = arrayList.get(i);
            if (vis[next] == 0) {
                ArrayList<Result> results = dfs(arr, value, n, vis, next, target);
                for (Result ne : results) {
                    if (ne.isTarget) {
                        int t = value[at][next];
                        if (t == -1) {
                            ne.haveNav++;
                        }
                        ne.val += t;
                        ne.rode.add(0, new int[]{at, next});
                        res.add(ne);
                    }
                }
            }
        }
        return res;
    }

    class Result {
        boolean isTarget;
        int haveNav;
        int val;
        ArrayList<int[]> rode;

        public Result() {
        }

        public Result(boolean isTarget, int haveNav, int val, ArrayList<int[]> rode) {
            this.isTarget = isTarget;
            this.haveNav = haveNav;
            this.val = val;
            this.rode = rode;
        }
    }
}