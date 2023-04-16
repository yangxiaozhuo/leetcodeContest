package baidu02;

import java.io.*;

/**
 * @author yangxiaozhuo
 * @date 2023/03/13
 */
public class Main {
    static char[] c = {'r', 'e', 'd'};
    static int[] dp = new int[200000];
    static int index = 0;

    static {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + i;
            if (dp[i] < 0) {
                dp[i] = dp[i - 1];
                for (int j = i + 1; j < dp.length; j++) {
                    dp[j] = dp[i];
                }
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        index = 0;
        out.println(fun(n));
        out.flush();
    }

    private static String fun(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            return sb.toString();
        }
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > n) {
                //  添加i - 1个字符
                for (int j = 0; j < i - 1; j++) {
                    sb.append(c[index % 3]);
                }
                index++;
                String s = fun(n - dp[i - 1]);
                return sb.toString() + s;
            }
        }
        return sb.toString();
    }
}
