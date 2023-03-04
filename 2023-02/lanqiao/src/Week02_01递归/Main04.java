package Week02_01递归;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 93. 递归实现组合型枚举
 * https://www.acwing.com/problem/content/95/
 *
 * @author yangxiaozhuo
 * @date 2023/02/20
 */
public class Main04 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] vis = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>(m);
        for (int i = 1; i <= n; i++) {
            vis[i] = 1;
            list.add(i);
            dfs(list, vis, m, i);
            vis[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    public static void dfs(ArrayList<Integer> list, int[] vis, int m, int at) {
        if (list.size() == m) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                sb.append(" ");

            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
            return;
        }
        for (int i = at + 1; i < vis.length; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                list.add(i);
                dfs(list, vis, m, i);
                vis[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
