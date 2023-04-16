package baidu03;

import java.io.*;
import java.util.ArrayList;

/**
 * @author yangxiaozhuo
 * @date 2023/03/13
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
        ArrayList<Integer>[] lists = new ArrayList[n];
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] s1 = in.readLine().split(" ");
            int a = Integer.parseInt(s1[0]) - 1;
            int b = Integer.parseInt(s1[1]) - 1;
            lists[a].add(b);
            lists[b].add(a);
        }
        out.println(0);
//        out.println(fun(n, 0));
        out.flush();
    }
}
