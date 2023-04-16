package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/04/08
 */
public class Main03 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = in.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int s = Integer.parseInt(ss[2]);
        ss = in.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        //输入到此结束
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE); //都给一个很大的值
        dp[0] = nums[0] + s;
        for (int i = 1; i < n; i++) {
            //求dp[i]
            int max = nums[i];
            int min = nums[i];
            for (int j = 0; j < m && i - j >= 0; j++) {
                max = Math.max(max, nums[i - j]);
                min = Math.min(min, nums[i - j]);
                if (i == j) {
                    dp[i] = Math.min(dp[i], s + (j + 1) * ((min + max) / 2));
                } else {
                    dp[i] = Math.min(dp[i], dp[i - j - 1] + s + (j + 1) * ((min + max) / 2));
                }
            }
        }
        System.out.println(dp[n - 1]);
    }
}
