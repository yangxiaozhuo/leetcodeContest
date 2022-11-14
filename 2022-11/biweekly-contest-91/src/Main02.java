/**
 * 6238. 统计构造好字符串的方案数
 *
 * @author yangxiaozhuo
 * @date 2022/11/12
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countGoodStrings(200, 200, 10, 1));
    }

    static class Solution {
        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] dp = new int[high + 2];
            dp[0] = 1;
            int mod = 1000000007;
            for (int i = 1; i < high + 2; i++) {
                if (i - one >= 0) {
                    dp[i] = (dp[i] + dp[i - one]) % mod;
                }
                if (i - zero >= 0) {
                    dp[i] = (dp[i] + dp[i - zero]) % mod;
                }
            }
            int res = 0;
            for (int i = low; i < high + 1; i++) {
                res = (res + dp[i]) % mod;
            }
            return res % mod;
        }
    }
}
