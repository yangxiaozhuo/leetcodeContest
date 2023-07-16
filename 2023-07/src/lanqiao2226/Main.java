package lanqiao2226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author yangxiaozhuo
 * @date 2023/06/05
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        long l = Long.parseLong(s[0]);
        long r = Long.parseLong(s[1]);
        long res = 0;
        for (long i = l; i <= r; i++) {
            if (check(i)) {
                res += i;
            }
        }
        System.out.println(res);
    }

    private static boolean check(long i) {
        String s = i + "";
        char[] chars = s.toCharArray();
        for (int j = 0; j < chars.length - 3; j++) {
            if (chars[j] == '2' && chars[j + 1] == '0' && chars[j + 2] == '2' && chars[j + 3] =='2') {
                return true;
            }
        }
        return false;
    }
}
