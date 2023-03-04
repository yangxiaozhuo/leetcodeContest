package Week01_01前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1230. K倍区间
 * https://www.acwing.com/problem/content/1232/
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main04 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        long[] num = new long[n + 1];
        long[] pre = new long[k + 1];
        long res = 0;
        for (int i = 1; i <= n; i++) {
            num[i] = num[i - 1] + Integer.parseInt(in.readLine());
            int t = (int)(num[i] % k);
            res += pre[t];
            pre[t]++;
            if(t == 0) {
                res++;
            }
        }
        System.out.println(res);
    }
}
