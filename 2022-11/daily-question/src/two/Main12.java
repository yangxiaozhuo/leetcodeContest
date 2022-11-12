package two;

/**
 * 790. 多米诺和托米诺平铺
 * f(n) = f(n - 1) + f(n - 2) + 2 *[f(n - 3) + f(n - 2) +..+f(1) + 1]
 *
 * @author yangxiaozhuo
 * @date 2022/11/12
 */
public class Main12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTilings(1000));
    }

    static class Solution {
        static long[] dp = new long[1005];

        static {
            int mod = 1000000007;
            long[] sum = new long[1006];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 5;
            sum[1] = 1;
            sum[2] = 2;
            sum[3] = 4;
            sum[4] = 9;
            for (int i = 4; i < 1001; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + 2L * sum[i - 2]) % mod;
                sum[i + 1] = (sum[i] + dp[i]) % mod;
            }
        }

        public int numTilings(int n) {
            return (int) dp[n];
        }
    }
}
