package text01;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int v = Integer.parseInt(s[1]);
        int cnt = 0;
        int[][] dp = new int[110][110];
        int[][][] vw = new int[110][100][2];
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(in.readLine());
            for (int j = 1; j <= num; j++) {
                s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                cnt++;
                vw[i][j][0] = a;  //i组 j个的 体积
                vw[i][j][1] = b;  //         价值
            }
        }
        for (int i = 1; i <= cnt; i++) {  //前i组
            for (int j = 1; j <= v; j++) {  //体积j
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k < vw[i].length; k++) {  //选哪一个
                    int a = vw[i][k][0]; //体积
                    int b = vw[i][k][1]; //价值
                    if (j - a >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - a] + b);
                    }
                }
            }
        }
        out.println(dp[cnt][v]);
        out.flush();
    }
}