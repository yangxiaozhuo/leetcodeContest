package test04;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/06/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        "1000000007"
//        "2000000014"
//        1
//        400
        System.out.println(solution.count("1", "12", 1, 8));
        System.out.println(solution.count("1000000007", "2000000014", 1, 400));
    }
}

class Solution {
    int mod = 1000_000_007;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        return fun(num2, min_sum, max_sum) - fun(num1, min_sum, max_sum) + check(num1, min_sum, max_sum);
    }

    private int fun(String num, int min_sum, int max_sum) {
        int[][] dp = new int[num.length() + 1][Math.min(num.length() * 9, max_sum)];
        for (int[] t : dp) {
            Arrays.fill(t, -1);
        }
        int res = dfs(0, 0, true, dp, max_sum, min_sum, num);
        return res;
    }

    private int dfs(int p, int sum, boolean limit, int[][] dp, int max_sum, int min_sum, String num) {
        int res = 0;
        if (sum > max_sum) {
            return 0;
        }
        if (p == num.length()) {
            if (sum >= min_sum && sum <= max_sum) {
                return 1;
            }
            return 0;
        }
        if (!limit) {
            if (dp[p][sum] != -1) {
                return dp[p][sum];
            }
        }
        int up = 0;
        if (limit) {
            up = num.charAt(p) - '0';
        } else {
            up = 9;
        }
        for (int i = 0; i <= up; i++) {
            res = res + dfs(p + 1, sum + i, limit && (i == up), dp, max_sum, min_sum, num);
            res = res % mod;
        }
        dp[p][sum] = res;
        return res;
    }

    public int check(String num, int min, int max) {
        int sum = 0;
        for (char c : num.toCharArray()) {
            sum = sum + c - '0';
        }
        return (sum >= min && sum <= max) ? 1 : 0;
    }
}
