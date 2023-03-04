package Week02_03哈希;

import java.io.*;
import java.util.HashSet;

/**
 * 840. 模拟散列表
 * https://www.acwing.com/problem/content/842/
 *
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main02 {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> set = new HashSet<>(200000);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] s = in.readLine().split(" ");
            if (s[0].equals("I")) {
                set.add(Integer.parseInt(s[1]));
            } else {
                if (set.contains(Integer.parseInt(s[1]))) {
                    out.println("Yes");
                } else {
                    out.println("No");
                }
            }
        }
        out.flush();
    }
}
