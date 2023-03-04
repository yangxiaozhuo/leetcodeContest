package Week02_03哈希;

import java.io.*;
import java.util.HashSet;

/**
 * 2058. 笨拙的手指
 * https://www.acwing.com/problem/content/2060/
 * 有坑，原来的数字没有前导0，所以i=0时，不能让此数字为一
 *      但是如果只有一个数字，（二进制）1和（三进制）2答案应该为0，特例特判
 *
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String s = in.readLine();
        if (s.charAt(0) == '0') {
            char[] chars = s.toCharArray();
            chars[0] = '1';
            out.println(tow(chars, 2));
            out.flush();
            return;
        }
        if (s.length() == 1) {
            out.println(0);
            out.flush();
            return;
        }
        String s2 = in.readLine();
        if (s2.charAt(0) == '0') {
            char[] chars = s2.toCharArray();
            chars[0] = '1';
            out.println(tow(chars, 3));
            out.flush();
            return;
        }
        HashSet<Long> set = new HashSet<>();
        char[] chars = s.toCharArray();
        long t = tow(chars, 2);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                long temp = 1 << (chars.length - i - 1);
                set.add(t | temp);
            } else {
                long temp = 1 << (chars.length - i - 1);
                set.add(t ^ temp);
            }
        }
        chars = s2.toCharArray();
        long[] dp = new long[32];
        t = tow(chars, 3);
        for (int i = 0; i < chars.length; i++) {
            long temp = find(dp, chars.length - 1 - i);
            if (chars[i] == '0') {
                if (set.contains(t + temp)) {
                    out.println(t + temp);
                    out.flush();
                    return;
                }
                if (set.contains(t + temp + temp)) {
                    out.println(t + temp + temp);
                    out.flush();
                    return;
                }
            } else if (chars[i] == '1') {
                if (set.contains(t + temp)) {
                    out.println(t + temp);
                    out.flush();
                    return;
                }
                if (i != 0 && set.contains(t - temp)) {
                    out.println(t - temp);
                    out.flush();
                    return;
                }
            } else {
                if (i != 0 && set.contains(t - 2 * temp)) {
                    out.println(t - 2 * temp);
                    out.flush();
                    return;
                }
                if (set.contains(t - temp)) {
                    out.println(t - temp);
                    out.flush();
                    return;
                }
            }
        }
    }

    private static long find(long[] dp, int i) {
        if (i == 0) {
            return 1;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        long temp = find(dp, i / 2);
        dp[i] = temp * temp;
        if (i % 2 != 0) {
            dp[i] *= 3;
        }
        return dp[i];
    }

    private static long tow(char[] chars, int t) {
        long res = 0;
        for (int i = 0; i < chars.length; i++) {
            res = res + chars[i] - '0';
            res *= t;
        }
        return res / t;
    }
}
