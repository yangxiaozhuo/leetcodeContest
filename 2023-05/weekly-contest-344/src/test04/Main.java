package test04;

import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/05/07
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minIncrements(7, new int[]{1, 5, 2, 2, 3, 3, 1}));
    }
}

class Solution {
    int max = 0;
    int res = 0;
    int[] dp;

    public int minIncrements(int n, int[] cost) {
        max = cost[0];
        res = 0;
        dp = new int[cost.length];
        dfs(cost, 1, 0);
//        System.out.println(Arrays.toString(dp));
        dfs2(cost, 1, 0);
        return res;
    }

    private void dfs2(int[] cost, int at, int sum) {
        int index = at - 1;
        if (index >= cost.length) {
            return;
        }
        if (dp[index] != max - sum) {
            int div = max - dp[index] - sum;
            res += div;
            add(dp, at, div);
        }
        dfs2(cost, at * 2, sum + cost[index]);
        dfs2(cost, at * 2 + 1, sum + cost[index]);
    }

    private void add(int[] dp, int at, int div) {
        int index = at - 1;
        if (index >= dp.length) {
            return;
        }
        dp[index] += div;
        add(dp, at * 2, div);
        add(dp, at * 2 + 1, div);
    }

    private void dfs(int[] cost, int at, int sum) {
        int index = at - 1;
        if (index >= cost.length) {
            return;
        }
        max = Math.max(max, sum + cost[index]);
        dfs(cost, at * 2, sum + cost[index]);
        dfs(cost, at * 2 + 1, sum + cost[index]);
        int temp = 0;
        if (at * 2 - 1 < cost.length) {
            temp = Math.max(temp, dp[at * 2 - 1]);
        }
        if (at * 2 < cost.length) {
            temp = Math.max(temp, dp[at * 2]);
        }
        dp[index] = dp[index] + cost[index] + temp;
    }
}