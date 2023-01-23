package acwing.Week4Day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acwing.com/problem/content/4731/
 *
 * @author yangxiaozhuo
 * @date 2023/01/19
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int max = 1000_000_000;
        if (a == 1) {
            System.out.println(1);
            return;
        }
        if (b == 1) {
            System.out.println(a);
            return;
        }
        long temp = 1;
        while (b-- > 0) {
             temp = temp * a;
             if (temp > max) {
                 System.out.println(-1);
                 return;
             }
        }
        System.out.println(temp);
    }
}
