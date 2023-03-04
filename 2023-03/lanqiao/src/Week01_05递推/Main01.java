package Week01_05递推;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3777. 砖块
 * https://www.acwing.com/problem/content/3780/
 *
 * @author yangxiaozhuo
 * @date 2023/02/17
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String s = in.readLine();
            fun(n, s.toCharArray());
        }
    }

    private static void fun(int n, char[] chars) {
        StringBuffer sb = new StringBuffer();
        int t = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != 'W') {
                t++;
                sb.append(i + 1);
                sb.append(" ");
                chars[i] = chars[i] == 'W' ? 'B' : 'W';
                chars[i + 1] = chars[i + 1] == 'W' ? 'B' : 'W';
            }
        }
        if (chars[chars.length - 1] == 'W') {
            if (t == 0) {
                System.out.println(0);
                return;
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(t);
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != 'B') {
                t++;
                sb.append(i + 1);
                sb.append(" ");
                chars[i] = chars[i] == 'W' ? 'B' : 'W';
                chars[i + 1] = chars[i + 1] == 'W' ? 'B' : 'W';
            }
        }
        if (chars[chars.length - 1] == 'B') {
            if (t == 0) {
                System.out.println(0);
                return;
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(t);
            System.out.println(sb.toString());
            return;
        }
        System.out.println(-1);
    }
}
