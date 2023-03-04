package Week01_02差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 797. 差分
 * https://www.acwing.com/problem/content/799/
 *
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int T = Integer.parseInt(s[1]);
        s = in.readLine().split(" ");
        int[] nums = new int[n + 2];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = Integer.parseInt(s[i]);
        }
        int[] div = new int[n + 2];
        while (T-- > 0) {
            s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            div[a] += x;
            div[b + 1] -= x;
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += div[i];
            sb.append(sum + nums[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
