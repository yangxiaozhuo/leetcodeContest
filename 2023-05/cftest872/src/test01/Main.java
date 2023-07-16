package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/05/08
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s = in.readLine();
            System.out.println(fun(s));
        }
    }

    private static int fun(String s) {
        int res = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1- i)) {
                return s.length();
            }
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        if (set.size() == 1) {
            return -1;
        }
        return s.length() - 1;
    }
}
