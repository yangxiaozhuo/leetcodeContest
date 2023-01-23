package acwing.Week3Day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/4703/
 *
 * @author yangxiaozhuo
 * @date 2023/01/19
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int money = Integer.parseInt(s[1]);
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in.readLine());
            sum += nums[i];
        }
        money = sum - money;
        Arrays.sort(nums);
        int[][] dp = new int[n + 1][money + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < money + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < money + 1; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        System.out.println(sum - dp[n][money]);
    }
}