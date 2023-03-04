package Week01_03二分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 789. 数的范围
 * https://www.acwing.com/problem/content/791/
 *
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);
        int[] nums = new int[n + 2];
        s = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
        }
        nums[n + 1] = 20000;
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(in.readLine());
            fun(x, nums);
        }
    }

    private static void fun(int x, int[] nums) {
        int l = findLow(x, nums) - 1;
        int r = findBig(x, nums) - 1;
        if (l < r) {
            System.out.println("-1 -1");
        } else {
            System.out.println(r + " " + l);
        }
    }

    private static int findBig(int x, int[] nums) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static int findLow(int x, int[] nums) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
