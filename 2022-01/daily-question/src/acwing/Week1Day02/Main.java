package acwing.Week1Day02;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/description/3403/
 *
 * @author yangxiaozhuo
 * @date 2023/01/07
 */
public class Main{
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int res = 0;
        dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            res += fun(i, k);
        }
        System.out.println(res);
    }
    static public int fun(int n, int k) {
        if(dp[n] != 0) {
            return dp[n];
        }
        if(n == 0) {
            return 0;
        }
        if(n % 10 == k) {
            dp[n] = fun(n / 10, k) + 1;
        } else {
            dp[n] = fun(n / 10, k);
        }
        return dp[n];
    }
}