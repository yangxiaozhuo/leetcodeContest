package acwing.Week4Day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author yangxiaozhuo
 * @date 2023/01/20
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String[] s = in.readLine().split(" ");
            long n = Long.parseLong(s[0]);
            long d = Long.parseLong(s[1]);
            long e = Long.parseLong(s[2]);
            long m = n - d * e + 2;
            long temp = m * m - 4 * n;
            if (m <= 0 || temp < 0 || Math.sqrt(temp) - (long) Math.sqrt(temp) != 0) {
                System.out.println("NO");
            } else {
                long sq = (long) Math.sqrt(temp);
                long x1 = m - sq;
                long x2 = m + sq;
                if (x1 % 2 == 0 && x2 % 2 == 0) {
                    System.out.println(x1 / 2 + " " + x2 / 2);
                }else {
                    System.out.println("NO");
                }
            }
        }
    }

//    private static long sqrt(long target) {
//        long l = 1;
//        long r = target;
//        while (l < r) {
//            long mid = l + r >> 1;
//            if (mid >= target / mid) {
//                r = mid;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return l;
//    }
}

