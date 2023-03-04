package Week01_04双指针;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1240. 完全二叉树的权值
 * https://www.acwing.com/problem/content/1242/
 *
 * @author yangxiaozhuo
 * @date 2023/02/17
 */
public class Main03 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = Integer.parseInt(s[i]);
        }
        long res = 1;
        long max = nums[1];
        long lay = 1;
        int l = 1;
        int r = 0;
        while (r <= n) {
            long temp = 0;
            while (r <= n && r - l < (1 << (lay - 1))) {
                temp += nums[r];
                r++;
            }
            if (temp > max) {
                max = temp;
                res = lay;
            }
            lay++;
            l = r;
        }
        System.out.println(res);
    }
}
