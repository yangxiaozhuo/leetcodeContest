import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/01/15
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{1,1,2,2},{0,0,1,1,}};
        System.out.println(Arrays.deepToString(solution.rangeAddQueries(3, ints)));
    }
    static class Solution {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            int[][] res = new int[n][n];
            for (int i = 0; i < queries.length; i++) {
                int a = queries[i][0];
                int b = queries[i][1];
                int c = queries[i][2];
                int d = queries[i][3];
                for (int j = a; j <= c; j++) {
                    for (int k = b; k <= d; k++) {
                        res[j][k]++;
                    }
                }
            }
            return res;
        }
    }
}
