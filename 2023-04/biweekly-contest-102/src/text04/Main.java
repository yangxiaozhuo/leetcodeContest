package text04;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/04/15
 */
public class Main {
    public static void main(String[] args) {

//        ["Graph","shortestPath","shortestPath","addEdge","shortestPath"]
//[[4,[[0,2,5],[0,1,2],[1,2,1],[3,0,3]]],[3,2],[0,3],[[1,3,4]],[0,3]]
//        ["Graph","shortestPath","shortestPath","shortestPath","addEdge","addEdge","shortestPath","shortestPath","addEdge","addEdge","shortestPath","shortestPath","shortestPath","addEdge","addEdge","addEdge","addEdge","shortestPath","addEdge","shortestPath","addEdge","shortestPath","shortestPath","addEdge","shortestPath","shortestPath","shortestPath","shortestPath","addEdge","shortestPath","shortestPath","addEdge","shortestPath","addEdge","addEdge","addEdge","shortestPath","addEdge","addEdge","shortestPath"]
//[[6,[[0,4,617630],[5,3,501040],[3,4,654340],[5,1,277928],[4,3,519665]]],[3,4],[1,1],[1,1],[[4,2,36803]],[[5,2,156440]],[2,2],[3,3],[[4,1,138227]],[[4,5,1455]],[5,3],[2,3],[5,4],[[5,0,1370]],[[2,3,1339]],[[0,5,100]],[[2,4,233518]],[0,1],[[1,4,70]],[4,0],[[5,4,43]],[4,3],[2,5],[[3,2,16]],[5,5],[3,2],[2,3],[0,0],[[0,1,688464]],[4,3],[4,4],[[1,0,5]],[5,2],[[1,5,1]],[[1,3,781555]],[[3,5,1]],[1,2],[[2,0,1]],[[0,3,1]],[0,2]]
        int[][] ints = new int[][]{{0,4,617630}, {5,3,501040}, {3,4,654340}, {5,1,277928},{4,3,519665}};
        Graph graph = new Graph(6, ints);
        System.out.println(graph.shortestPath(3,4));
        System.out.println(graph.shortestPath(1,1));
        System.out.println(graph.shortestPath(1,1));
        graph.addEdge(new int[]{4,2,36803});
        graph.addEdge(new int[]{5,2,156440});
        System.out.println(graph.shortestPath(1,1));
        System.out.println(graph.shortestPath(1,1));
        graph.addEdge(new int[]{4,1,138227});
        graph.addEdge(new int[]{4,5,1455});
        System.out.println(graph.shortestPath(5, 3));
        System.out.println(graph.shortestPath(2, 3));
        System.out.println(graph.shortestPath(5, 4));
    }
}

class Graph {
    ArrayList<int[]>[] arr;
    int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        arr = new ArrayList[n];
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int v = edges[i][2];
            if (arr[a] == null) {
                arr[a] = new ArrayList<>();
            }
            arr[a].add(new int[]{b, v});
        }
    }

    public void addEdge(int[] edge) {
        int a = edge[0];
        int b = edge[1];
        int v = edge[2];
        if (arr[a] == null) {
            arr[a] = new ArrayList<>();
        }
        arr[a].add(new int[]{b, v});
    }

    public int shortestPath(int node1, int node2) {
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[node1] = 0;
        dfs(res, node1, node2, new int[n]);
        if (res[node2] == Integer.MAX_VALUE) {
            return -1;
        }
        return res[node2];
    }

    private void dfs(int[] res, int node1, int node2, int[] vis) {
        if (node1 == node2) {
            return;
        }
        //当前点可以去的点
        ArrayList<int[]> arrayList = arr[node1];
        if (arrayList == null) {
            vis[node1] = 1;
            int min = -1;
            int minid = 0;
            for (int i = 0; i < n; i++) {
                if (vis[i] != 1) {
                    if (min == -1 || res[i] < min) {
                        min = res[i];
                        minid = i;
                    }
                }
            }
            if (min != -1 && res[minid] != Integer.MAX_VALUE) {
                dfs(res, minid, node2, vis);
            }
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            int[] ints = arrayList.get(i);
            int to = ints[0];
            int val = ints[1];
            res[to] = Math.min(res[to], res[node1] + val);
        }
        vis[node1] = 1;
        int min = -1;
        int minid = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] != 1) {
                if (min == -1 || res[i] < min) {
                    min = res[i];
                    minid = i;
                }
            }
        }
        if (min != -1 && res[minid] != Integer.MAX_VALUE) {
            dfs(res, minid, node2, vis);
        }
    }
}
