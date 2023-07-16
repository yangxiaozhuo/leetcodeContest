package test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * @author yangxiaozhuo
 * @date 2023/05/05
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] s = in.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            fun(nums);
        }
    }

    private static void fun(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            int l = nums[nums.length - i - 1];
            int r = nums[i];
            int temp = Math.abs(l - r);
            res = gcd(res, temp);
        }
        System.out.println(res);
    }

    private static int gcd(int l, int r) {
        if (l == 0) {
            return r;
        }
        if (r % l == 0) {
            return l;
        }
        return gcd(r % l, l);
    }
}