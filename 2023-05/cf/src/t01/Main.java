package t01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/05/05
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = in.readLine().split(" ");
        int m = Integer.parseInt(ss[0]);
        int s = Integer.parseInt(ss[1]);
        if (s == 0) {
            if (m != 1) {
                System.out.println("-1 -1");
            } else {
                System.out.println("0 0");
            }
            return;
        }
        if (m * 9 < s) {
            System.out.println("-1 -1");
            return;
        }
        String min = findMin(s, m);
        String max = findMax(s, m);
        System.out.println(min + " " + max);
    }

    private static String findMax(int s, int m) {
        char[] chars = new char[m];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (Math.min(9, s) + '0');
            s = s - Math.min(9, s);
        }
        return new String(chars);
    }

    private static String findMin(int s, int m) {
        s--;
        char[] chars = new char[m];
        for (int i = m - 1; i >= 0; i--) {
            chars[i] = (char) (Math.min(9, s) + '0');
            s = s - Math.min(9, s);
        }
        chars[0] = (char) (chars[0] + 1);
        return new String(chars);
    }
}
