package Week01_01前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 796. 子矩阵的和
 * https://www.acwing.com/problem/content/798/
 *
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main03 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int q = Integer.parseInt(s[2]);
        int[][] num = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            s = in.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                num[i][j] = num[i - 1][j] + num[i][j - 1] - num[i - 1][j - 1] + Integer.parseInt(s[j - 1]);
            }
        }
        while (q-- > 0) {
            s = in.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);
            System.out.println(num[x2][y2] - num[x2][y1 - 1] - num[x1 - 1][y2] + num[x1 - 1][y1 - 1]);
        }
    }
}
