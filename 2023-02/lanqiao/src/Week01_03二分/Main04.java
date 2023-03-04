package Week01_03二分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1227. 分巧克力
 * https://www.acwing.com/problem/content/1229/
 *
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main04 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            s = in.readLine().split(" ");
            nums[i][0] = Integer.parseInt(s[0]);
            nums[i][1] = Integer.parseInt(s[1]);
        }
        int i = 1;
        int j = 100000;
        while (i < j) {
            int mid = i + j + 1 >> 1;
            if (check(mid, nums) >= k) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        System.out.println(i);
    }

    private static int check(int mid, int[][] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res + (nums[i][0] / mid) * (nums[i][1] / mid);
        }
        return res;
    }
}
