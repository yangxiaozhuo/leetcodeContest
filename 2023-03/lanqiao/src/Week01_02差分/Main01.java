package Week01_02差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3729. 改变数组元素
 * https://www.acwing.com/problem/content/3732/
 *
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] s = in.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            fun(nums, n);
        }
    }

    private static void fun(int[] nums, int n) {
        int[] div = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            div[i + 1]--;
            div[Math.max(0, i - nums[i] + 1)]++;
        }
        StringBuilder res = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < div.length - 1; i++) {
            sum += div[i];
            if (sum > 0) {
                res.append(1);
            } else {
                res.append(0);
            }
            res.append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        System.out.println(res.toString());
    }
}
