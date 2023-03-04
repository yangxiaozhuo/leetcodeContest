package Week01_01前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 99. 激光炸弹
 * https://www.acwing.com/problem/content/101/
 *
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main05 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        long[][] num = new long[5001][5001];
        long[][] sum = new long[5002][5002];
        for (int i = 0; i < n; i++) {
            s = in.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            num[x][y] += w;
        }
        for (int i = 0; i < 5001; i++) {
            for (int j = 0; j < 5001; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + num[i][j];
            }
        }
        long res = 0;
        if (r >= 5000) {
            System.out.println(sum[5001][5001]);
        } else {
            r = r - 1;
            for (int i = 1; i < 5002 - r; i++) {
                for (int j = 1; j < 5002 - r; j++) {
                    res = Math.max(res, sum[i + r][j + r] - sum[i - 1][j + r] - sum[i + r][j - 1] + sum[i - 1][j - 1]);
                }
            }
            System.out.println(res);
        }
    }
}
