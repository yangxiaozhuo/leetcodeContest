package two;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1691. 堆叠长方体的最大高度
 *
 * @author yangxiaozhuo
 * @date 2022/12/10
 */
public class Main10 {
    public static void main(String[] args) {
//[[50,45,20],[95,37,53],[45,23,12]]
//        int[][] ints = new int[][]{{7, 11, 17}, {7, 11, 17}, {7, 11, 17}, {7, 11, 17}, {7, 11, 17}, {7, 11, 17}};
        int[][] ints = new int[][]{{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        Solution solution = new Solution();
        System.out.println(solution.maxHeight(ints));
    }

    static class Solution {
        public int maxHeight(int[][] cuboids) {
            for (int[] cuboid : cuboids) {
                Arrays.sort(cuboid);
            }
            Arrays.sort(cuboids, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    if(o2[1] == o1[1]) {
                        return o2[2] - o1[2];
                    }
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            });
            int[] dp = new int[cuboids.length];
            for (int i = 0; i < cuboids.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (cuboids[j][1] >= cuboids[i][1] && cuboids[j][2] >= cuboids[i][2]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] += cuboids[i][2];
            }
            int res = 0;
            for (int j : dp) {
                res = Math.max(res, j);
            }
            return res;
        }
    }
}
