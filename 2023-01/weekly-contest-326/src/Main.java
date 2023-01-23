import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/01/19
 */
public class Main {
    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int t = Integer.parseInt(s[2]);
        min = t;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] s1 = in.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (s1[j] == '#') {
                    nums[i][j] = 0;
                } else {
                    nums[i][j] = -1;
                }
            }
        }
        int p = Integer.parseInt(in.readLine());
        int[][] dis = new int[n][m];
        while (p-- > 0) {
            String[] s1 = in.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            dis[a][b] = 1;
        }
        dfs(nums, n - 1, m - 1, new int[n][m], 0, dis);
        System.out.println(Math.max(0, t - min));
    }

    private static void dfs(int[][] nums, int i, int j, int[][] vis, int cost, int[][] dis) {
        if (i == nums.length || j == nums[0].length || i < 0 || j < 0 || vis[i][j] == 1 || nums[i][j] == -1 || cost > min) {
            return;
        }
        if (i == 0 && j == 0) {
            min = Math.min(min, cost + dis[0][0]);
            return;
        }
        vis[i][j] = 1;
        cost = dis[i][j] + cost;
        dfs(nums, i + 1, j, vis, cost, dis);
        dfs(nums, i, j + 1, vis, cost, dis);
        dfs(nums, i - 1, j, vis, cost, dis);
        dfs(nums, i, j - 1, vis, cost, dis);
        vis[i][j] = 0;
    }
}
