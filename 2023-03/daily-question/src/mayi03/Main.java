package mayi03;

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
        int m = Integer.parseInt(s[1]);
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = in.readLine().split(" ");
            for (int j = 0; j < s1.length; j++) {
                nums[i][j] = Integer.parseInt(s1[j]);
            }
        }
    }
}
