package Week01_03二分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 1460. 我在哪？
 * https://www.acwing.com/activity/content/problem/content/8027/
 *
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
        int l = 0;
        int r = s.length();
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid, s)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    private static boolean check(int mid, String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - mid; i++) {
            String substring = s.substring(i, i + mid);
            if (set.contains(substring)) {
                return false;
            }
            set.add(substring);
        }
        return true;
    }
}
