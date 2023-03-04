package Week01_01前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3956. 截断数组
 * https://www.acwing.com/problem/content/3959/
 *
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        if (n < 3) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = nums[i] + Integer.parseInt(s[i]);
        }
        if (nums[n] % 3 != 0) {
            System.out.println(0);
            return;
        }
        long res = 0;
        long cnt = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i - 1] == nums[n] / 3) {
                cnt++;
            }
            if (nums[i] == nums[n] / 3 * 2) {
                res += cnt;
            }
        }
        System.out.println(res);
    }
}
