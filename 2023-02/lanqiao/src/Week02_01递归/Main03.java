package Week02_01递归;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 94. 递归实现排列型枚举
 * https://www.acwing.com/problem/content/96/
 *
 * @author yangxiaozhuo
 * @date 2023/02/20
 */
public class Main03 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] vis = new int[n];
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            vis[i] = 1;
            list.add(i + 1);
            dfs(list, vis);
            list.remove(list.size() - 1);
            vis[i] = 0;
        }
    }

    public static void dfs(ArrayList<Integer> list, int[] vis) {
        if (list.size() == vis.length) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                sb.append(" ");

            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                list.add(i + 1);
                dfs(list, vis);
                vis[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
