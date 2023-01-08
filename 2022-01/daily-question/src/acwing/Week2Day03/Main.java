package acwing.Week2Day03;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/4656/
 *
 * @author yangxiaozhuo
 * @date 2023/01/03
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(in.readLine());
        int n = Integer.parseInt(in.readLine());
        Integer[] res = new Integer[m];
        int[] b = new int[m];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
            b[i] = fun(res[i]);
        }
        Arrays.sort(res, (o1, o2) -> {
            if (b[o1 - 1] != b[o2 - 1]) {
                return b[o1 - 1] - b[o2 - 1];
            } else {
                return o1 - o2;
            }
        });
        System.out.println(res[n - 1]);
    }

    private static int fun(int num) {
        int res = 0;
        while (num != 0) {
            res = res + num % 10;
            num = num / 10;
        }
        return res;
    }
}