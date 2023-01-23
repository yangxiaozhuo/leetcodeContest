import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/01/20
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int[] value = new int[n];
        for (int i = 0; i < s.length; i++) {
            value[i] = Integer.parseInt(s[i]);
        }
        char[][] graph = new char[n][n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = in.readLine().toCharArray();
        }
        int T = Integer.parseInt(in.readLine());
        long[][][] dp = new long[n][n][2];
        fun(dp, graph, value);
        while (T-- > 0) {
            s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]) - 1;
            int b = Integer.parseInt(s[1]) - 1;
            if (dp[a][b][1] != 0) {
                System.out.println(dp[a][b][1] + value[a]);
            } else {
                System.out.println("Impossible");
            }
        }
    }

    private static void fun(long[][][] dp, char[][] graph, int[] value) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 'Y') {
                    dp[i][j][1] = value[j];
                    dp[i][j][0] = 1;
                }
            }
        }
        for (int i = 1; i < graph.length; i++) {
            genxin(dp, graph, value, i);
        }
    }

    private static void genxin(long[][][] dp, char[][] graph, int[] value, int depth) {
        for (int i = 0; i < graph.length; i++) {
            long[] temp = new long[graph.length];
            Arrays.fill(temp, -1);
            for (int j = 0; j < graph.length; j++) {
                if (dp[i][j][0] == depth) {
                    for (int k = 0; k < graph.length; k++) {
                        if (dp[j][k][0] == 1) {
                            temp[k] = Math.max(temp[k], dp[i][j][1]  + dp[j][k][1]);
                        }
                    }
                }
            }
            for (int j = 0; j < graph.length; j++) {
                if (temp[j] != -1 && dp[i][j][0] == 0) {
                    dp[i][j][0] = depth + 1;
                    dp[i][j][1] = temp[j];
                }
            }
        }
    }
}
