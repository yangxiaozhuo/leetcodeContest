package acwing.Week1Day01;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/description/4264/
 *
 * @author yangxiaozhuo
 * @date 2023/01/07
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
        char[] chars = s.toCharArray();
        long res = 0;
        int[] dpL = new int[n];
        int[] dpR = new int[n];
        int gn = 0;
        int hn = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'G') {
                dpL[i] = hn;
                gn++;
                hn = 0;
            } else {
                dpL[i] = gn;
                hn++;
                gn = 0;
            }
        }
        gn = 0;
        hn = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == 'G') {
                dpR[i] = hn;
                gn++;
                hn = 0;
            } else {
                dpR[i] = gn;
                hn++;
                gn = 0;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            res = res + 1L * dpL[i] * dpR[i] + Math.max(dpL[i] - 1, 0) + Math.max(dpR[i] - 1, 0);
        }
        System.out.println(res);
    }
}