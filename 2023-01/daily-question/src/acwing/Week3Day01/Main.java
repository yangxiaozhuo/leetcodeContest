package acwing.Week3Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acwing.com/problem/content/4659/
 *
 * @author yangxiaozhuo
 * @date 2023/01/08
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] nums = new int[n][2];
        for (int i = 0; i < nums.length; i++) {
            s = in.readLine().split(" ");
            nums[i][0] = Integer.parseInt(s[0]);
            nums[i][1] = Integer.parseInt(s[1]);
        }
        long res = 0;
        int l = 0;
        int r = 100000;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (fun(nums, mid, m)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        int had = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i][0];
            int div = nums[i][1];
            if (num < l) {
                continue;
            }
            int t = (num - l) / div;
            had = had + t + 1;
            res = res + (t + 1) * num - (t + 1) * t / 2 * div;
        }
        System.out.println(res + (m - had) * l);
    }

    private static boolean fun(int[][] nums, int mid, int m) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i][0];
            int div = nums[i][1];
            if (num < mid) {
                continue;
            }
            res = res + (num - mid) / div + 1;
            if (res > m) {
                return false;
            }
        }
        return res <= m;
    }
}
