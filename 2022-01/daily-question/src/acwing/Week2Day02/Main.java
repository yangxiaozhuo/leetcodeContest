package acwing.Week2Day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acwing.com/problem/content/description/4647/
 *
 * @author yangxiaozhuo
 * @date 2023/01/03
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int n = Integer.parseInt(s);
        String[] s1 = in.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < s1.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        long res = 0;
        long temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            res = res + temp * nums[i];
            temp = temp + nums[i];
        }
        System.out.println(res);
    }
}
