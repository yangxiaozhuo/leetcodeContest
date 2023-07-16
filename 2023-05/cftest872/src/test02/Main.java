package test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/05/08
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            String[] s1 = in.readLine().split(" ");
            int[] nums = new int[n * m];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s1[i]);
            }
            System.out.println(fun(nums, Math.min(n, m), Math.max(n, m)));
        }
    }

    private static long fun(int[] nums, long n, long m) {
        //m > n
        Arrays.sort(nums);
        long max = nums[nums.length - 1];
        long max2 = nums[nums.length - 2];
        long min = nums[0];
        long min2 = nums[1];
        long temp1 = (m - 1) * n * (max - min) + (n - 1) * (max - min2);
        long temp2 = (m - 1) * n * max + (n - 1) * max2 - min * (n * m - 1);
        return Math.max(temp1, temp2);
    }
}
