import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/01/20
 */
public class Main {
    static int mod = 998244353;
    static long[] dp2 = new long[200010];
    static long[] dp11 = new long[200010];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int len = s.length();
        dp2[0] = 1;
        dp2[1] = 2;
        dp11[0] = 1;
        dp11[1] = 11;
        for (int i = 2; i < dp2.length; i++) {
            dp2[i] = fastMi(i, dp2);
            dp11[i] = fastMi(i, dp11);
        }
        long res = 0;
        for (int i = 0; i < len; i++) {
            int num = s.charAt(i) - '0';
            res = res + (dp2[i] * num * dp11[len - i - 1]) % mod;
            res = res % mod;
        }
        System.out.println(res);
    }

    private static long fastMi(int n, long[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }
        if (n % 2 == 0) {
            long temp = fastMi(n / 2, dp);
            dp[n] = (temp * temp) % mod;
        } else {
            long temp = fastMi(n / 2, dp);
            dp[n] = ((temp * temp) % mod * dp[1]) % mod;
        }
        return dp[n];
    }
}