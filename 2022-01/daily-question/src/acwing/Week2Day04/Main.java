package acwing.Week2Day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/4658/
 *
 * @author yangxiaozhuo
 * @date 2023/01/04
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int[] pre = new int[n + 1];
        int m = Integer.parseInt(in.readLine());
        while (m-- > 0) {
            s = in.readLine().split(" ");
            int l = Integer.parseInt(s[0]) - 1;
            int r = Integer.parseInt(s[1]) - 1;
            pre[l]++;
            pre[r + 1]--;
        }
        long origin = 0;
        int[] t = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            t[i + 1] = t[i] + pre[i];
            origin = origin + t[i + 1] * nums[i];
        }
        Arrays.sort(t);
        Arrays.sort(nums);
        long res = 0;
        for (int i = nums.length - 1; i >= 0 && t[i + 1] > 0; i--) {
            res = res + t[i + 1] * nums[i];
        }
        System.out.println(res - origin);
    }
}
