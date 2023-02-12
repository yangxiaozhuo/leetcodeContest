package text01;

/**
 * @author yangxiaozhuo
 * @date 2023/02/10
 */
public class Main10 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{1,1,1,2,2,3};
        System.out.println(solution.dieSimulator(3, ints));
    }
    static class Solution {
        int mod = 1000_000_007;
        public int dieSimulator(int n, int[] rollMax) {
            long[] dp = new long[n + 1];
            long temp = fun(n,dp);
            for (int i = 0; i < rollMax.length; i++) {
                if (rollMax[i] >= n) {
                    //不管
                } else {
                    temp = temp - (n - rollMax[i]) * fun(n - rollMax[i] - 1,dp);
                    temp = (temp + (n - rollMax[i]) * mod) % mod;
                }
            }
            return (int)(temp % mod);
        }

        private long fun(int n, long[] dp) {
            if (n == 1) {
                dp[1] = 6;
                return dp[1];
            } else if (n == 0) {
                dp[0] = 1;
                return dp[0];
            }
            long temp = fun(n / 2 , dp);
            if (n % 2 == 0) {
                dp[n] = (temp * temp) % mod;
            } else {
                dp[n] = (temp * temp * 6) % mod;
            }
            return dp[n];
        }
    }
}
