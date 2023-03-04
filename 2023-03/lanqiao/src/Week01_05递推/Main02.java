package Week01_05递推;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 717. 简单斐波那契
 * https://www.acwing.com/problem/content/719/
 *
 * @author yangxiaozhuo
 * @date 2023/02/20
 */
public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        int a = 0;
        int b = 1;
        while (n-- > 0) {
            sb.append(a);
            sb.append(" ");
            int t = b;
            b = a + t;
            a = t;
        }
        System.out.println(sb.toString());
    }
}
