package two;

/**
 * 1971. 寻找图中是否存在路径
 *
 * @author yangxiaozhuo
 * @date 2022/12/19
 */
public class Main19 {
    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            int[] pnode = new int[n];
            for(int i = 0; i < n; i++) {
                pnode[i] = i;
            }
            for(int i = 0;i < edges.length; i++){
                union(edges[i][0], edges[i][1], pnode);
            }
            return find(source,pnode)==find(destination,pnode);
        }
        void union(int a, int b, int[] pnode) {
            a = find(a, pnode);
            b = find(b, pnode);
            pnode[b] = a;
        }
        int find(int a, int[] pnode) {
            if(a != pnode[a]) {
                pnode[a] = find(pnode[a], pnode);
            }
            return pnode[a];
        }
    }
}
