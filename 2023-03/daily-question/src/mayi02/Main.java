package mayi02;

import java.io.*;

/**
 * @author yangxiaozhuo
 * @date 2023/03/16
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int cnt = n;
        int[][] dp = new int[510][510];
        int[][][] vw = new int[510][510][2];
        int min = 0;
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(in.readLine());
            String[] jiage = in.readLine().split(" ");
            String[] xingneng = in.readLine().split(" ");
            int temp = Integer.MAX_VALUE;  //===
            for (int j = 1; j <= num; j++) {
                int a = Integer.parseInt(jiage[j - 1]);
                int b = Integer.parseInt(xingneng[j - 1]);
                temp = Math.min(temp, a);   // ===
                vw[i][j][0] = a;  //i组 j个的 价格
                vw[i][j][1] = b;  //         性能
            }
            min+=temp;
        }
        if(min > x) {
            out.println(-1);
            out.flush();
            return;
        }
        for (int i = 1; i <= cnt; i++) {  //前i组
            for (int j = 1; j <= x; j++) {  //体积j
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
        out.println(dp[cnt][x]);
        out.flush();
    }
}
