package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/05/06
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        String s = "codeforces";
        while (T-- > 0) {
            String s1 = in.readLine();
            int res = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s.charAt(i)) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}

