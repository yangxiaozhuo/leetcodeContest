package Week01_01前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 795. 前缀和
 * https://www.acwing.com/problem/content/797/
 *
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] num = new int[n + 1];
        s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i + 1] = num[i] + Integer.parseInt(s[i]);
        }
        while (m-- > 0) {
            s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            System.out.println(num[b] - num[a - 1]);
        }
    }
}
