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
        int[][] ints = new int[][]{{6,1},{3,2},{2,3}};
        System.out.println(solution.waysToReachTarget(7, ints));
    }
}

class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        int mod = 1000_000_007;
        int[][] dp = new int[types.length+1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= types.length; i++) {
            int temp = types[i - 1][1];  //分数
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k <= types[i - 1][0] && j - temp * k >= 0; k++) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - k * temp];
                    dp[i][j] = dp[i][j] % mod;
                }
            }
        }
        return dp[types.length][target];
    }
}