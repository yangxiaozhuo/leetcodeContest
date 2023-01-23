package acwing.Week4Day01;

/**
 * https://www.acwing.com/problem/content/4458/
 *
 * @author yangxiaozhuo
 * @date 2023/01/19
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        int[] nums = new int[200010];
        for (int i = 0; i < n; i++) {
            s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            nums[Math.max(0, a - k - b + 1)]++;
            nums[Math.max(0, a - k) + 1]--;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        while (m-- > 0) {
            int t = Integer.parseInt(in.readLine());
            System.out.println(nums[t]);
        }
    }
}
