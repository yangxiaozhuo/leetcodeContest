package text04;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//         [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k = 3
//        int[][] ints = new int[][]{{0, 1}, {1, 2}, {1, 3}, {4, 2}};
//        int[][] ints2 = new int[][]{{1, 3}, {0, 1}, {1, 0}, {2, 4}};
//        System.out.println(solution.rootCount(ints, ints2, 3));
//        int[][] ints = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 2}};
//        int[][] ints2 = new int[][]{{1, 0}, {3, 4}, {2, 1}, {3, 2}};
//        System.out.println(solution.rootCount(ints, ints2, 1));

//        [[0,1],[2,0],[0,3],[4,2],[3,5],[6,0],[1,7],[2,8],[2,9],[4,10],[9,11],[3,12],[13,8],[14,9],[15,9],[10,16]]
//[[8,2],[12,3],[0,1],[16,10]]
//        2
        int[][] ints = new int[][]{{0, 1}, {2, 0}, {0, 3}, {4, 2}, {3, 5}, {6, 0}, {1, 7}, {2, 8}, {2, 9}, {4, 10}, {9, 11}, {3, 12}, {13, 8}, {14, 9}, {15, 9}, {10, 16}};
        int[][] ints2 = new int[][]{{8, 2}, {12, 3}, {0, 1}, {16, 10}};  //4
        System.out.println(solution.rootCount(ints, ints2, 2));
    }
}

class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        HashMap<Integer, Integer>[] maps = new HashMap[edges.length + 1];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            maps[a].put(b, 0);
            maps[b].put(a, 0);
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < guesses.length; i++) {
            int a = guesses[i][0];
            int b = guesses[i][1]; //猜 a是b的父节点
            set.add(a + "->" + b);
        }
        dfs(maps, 0, new int[edges.length + 1], set);
        int res = 0;
        for (int i = 0; i < edges.length + 1; i++) {
            HashMap<Integer, Integer> map = maps[i];
            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sum += entry.getValue();
            }
            if (sum >= k) {
                res++;
            }
        }
        return res;
    }

    private int dfs(HashMap<Integer, Integer>[] maps, int at, int[] vis, HashSet<String> set) {  //会计算从at去其他方向，的值
        if (vis[at] == 1) {
            return 0;
        }
        vis[at] = 1;
        HashMap<Integer, Integer> map = maps[at];
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(at + "->" + entry.getKey())) {
                if (vis[entry.getKey()]!=1) {
                    entry.setValue(1 + dfs(maps, entry.getKey(), vis, set));
                }
            } else {
                entry.setValue(dfs(maps, entry.getKey(), vis, set));
            }
            sum += entry.getValue();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer next = entry.getKey();
            maps[next].put(at, sum - entry.getValue());
        }
        return sum;
    }
}