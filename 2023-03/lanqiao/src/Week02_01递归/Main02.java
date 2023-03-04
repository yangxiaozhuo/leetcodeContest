package Week02_01递归;

/**
 * 92. 递归实现指数型枚举
 * https://www.acwing.com/problem/content/94/
 *
 * @author yangxiaozhuo
 * @date 2023/02/20
 */

import java.io.*;

public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] ints = new int[n];
        dfs(ints, 1);
        ints[0] = 1;
        dfs(ints, 1);
    }

    public static void dfs(int[] ints, int at) {
        if (at == ints.length) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 1) {
                    sb.append(i + 1);
                    sb.append(" ");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            System.out.println(sb.toString());
            return;
        }
        dfs(ints, at + 1);
        ints[at] = 1;
        dfs(ints, at + 1);
        ints[at] = 0;
    }
}
