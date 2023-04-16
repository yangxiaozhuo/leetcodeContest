package a;

import java.io.*;

public class Main {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        max = 0;
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        int[][] nums = new int[n][m];
        char[][] color = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s1 = in.readLine();
            color[i] = s1.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            String[] s1 = in.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(s1[j]);
            }
        }
        dfs(nums, color, 0, 0, k, 0);
        out.println(max);
        out.flush();
    }

    private static void dfs(int[][] nums, char[][] color, int a, int b, int k, int sum) {
        int[][] dp = new int[nums.length][nums[0].length];
        for (int i = 1; i < nums[0].length; i++) {
            if (color[0][i] != color[0][i - 1]) {
                if (dp[0][i - 1] >= k) {
                    dp[0][i] = dp[0][i] - k + nums[0][i];
                } else {
                    break;
                }
            } else {
                dp[0][i] = dp[0][i] + nums[0][i];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (color[i][0] != color[i - 1][0]) {
                if (dp[i - 1][0] >= k) {
                    dp[i][0] = dp[i][0] - k + nums[i][0];
                } else {
                    break;
                }
            } else {
                dp[i][0] = dp[i][0] + nums[i][0];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++) {
                if (color[i - 1][j] != color[i][j]) {
                    if (dp[i - 1][j] >= k) {
                        dp[i][j] = dp[i - 1][j] - k + nums[i][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] + nums[i][j];
                }

                if (color[i][j - 1] != color[i][j]) {
                    if (dp[i][j - 1] >= k) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] - k + nums[i][j]);
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] + nums[i][j];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
    }
}
