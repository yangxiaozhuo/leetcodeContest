package t02;

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
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String[] s = in.readLine().split(" ");
            long k = Long.parseLong(s[1]);
            String s1 = in.readLine();
            fun(s1.toCharArray(), k);
        }
    }

    private static void fun(char[] chars, long k) {
        int one = 0;
        int zero = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                zero++;
                if (k >= one) {
                    k = k - one;
                } else {
                    //前面zero - 1 个0  one个1 然后此0往前挪k次，然后直接后面添加
                    for (int j = 0; j < zero - 1; j++) {
                        chars[j] = '0';
                    }
                    for (int j = 0; j < one; j++) {
                        chars[j + zero - 1] = '1';
                    }
                    chars[one + zero - 1] = '0';
                    swap(chars, one + zero - 1, (int)(one + zero - 1 - k));
                    System.out.println(new String(chars));
                    return;
                }
            } else {
                one++;
            }
        }
        for (int j = 0; j < zero; j++) {
            chars[j] = '0';
        }
        for (int j = 0; j < one; j++) {
            chars[zero + j] = '1';
        }
        System.out.println(new String(chars));
    }

    private static void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
