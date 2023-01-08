package acwing.Week2Day05;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/4655/
 *
 * @author yangxiaozhuo
 * @date 2023/01/07
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int num = s.charAt(1) - '0';
        int a = 1189;
        int b = 841;
        while (num-- > 0) {
            if (a > b) {
                a = a / 2;
            } else {
                b = b / 2;
            }
        }
        System.out.println(Math.max(a, b));
        System.out.println(Math.min(a, b));
    }
}
