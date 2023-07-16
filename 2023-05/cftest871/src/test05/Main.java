package test05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/05/06
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String[] s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int[][] nums = new int[a][b];
            for (int i = 0; i < a; i++) {
                s = in.readLine().split(" ");
                for (int j = 0; j < b; j++) {
                    nums[i][j] = Integer.parseInt(s[j]);
                }
            }
            System.out.println(fun(nums));
        }
    }

    private static int fun(int[][] nums) {
        int t = 1;
        int[][] vis = new int[nums.length][nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (vis[i][j] == 0 || nums[i][j] != 0) {
                    dfs(nums, i, j, vis, t);
                    t++;
                }
            }
        }
        int[] sum = new int[t];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                sum[vis[i][j]] += nums[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < sum.length; i++) {
            res = Math.max(res, sum[i]);
        }
        return res;
    }

    private static void dfs(int[][] nums, int i, int j, int[][] vis, int t) {
        if (i < 0 || j < 0 || i == nums.length || j == nums[0].length) {
            return;
        }
        if (vis[i][j] != 0 || nums[i][j] == 0) {
            return;
        }
        vis[i][j] = t;
        dfs(nums, i + 1, j, vis, t);
        dfs(nums, i, j + 1, vis, t);
        dfs(nums, i - 1, j, vis, t);
        dfs(nums, i, j - 1, vis, t);
    }
}
