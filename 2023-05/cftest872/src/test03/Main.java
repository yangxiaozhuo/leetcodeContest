package test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author yangxiaozhuo
 * @date 2023/05/08
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        if (k == 1 || k == 3) {
            System.out.println(1);
            return;
        }
        int[] nums = new int[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]) - 1;
            int b = Integer.parseInt(s[1]) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
//        dfs(0, )
        long temp = 666666674L * 6L;
        System.out.println(temp);
        System.out.println(temp % 1000000007);
    }
}
