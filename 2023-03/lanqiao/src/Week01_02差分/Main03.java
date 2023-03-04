package Week01_02差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 798. 差分矩阵
 * https://www.acwing.com/problem/content/800/
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
                num[i][j] = Integer.parseInt(s[j - 1]);
            }
        }
        int[][] div = new int[n + 2][m + 2];
        while (q-- > 0) {
            s = in.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);
            int val = Integer.parseInt(s[4]);
            div[x1][y1] += val;
            div[x1][y2 + 1] -= val;
            div[x2 + 1][y1] -= val;
            div[x2 + 1][y2 + 1] += val;
        }
        StringBuilder sb;
        for (int i = 1; i <= n; i++) {
            sb = new StringBuilder();
            for (int j = 1; j <= m; j++) {
                div[i][j] = div[i][j - 1] + div[i - 1][j] - div[i - 1][j - 1] + div[i][j];
                num[i][j] += div[i][j];
                sb.append(num[i][j]);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
