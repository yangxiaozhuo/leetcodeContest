package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + r >> 1;
            int temp = check(mid, nums);
            if (temp > mid) {
                l = mid + 1;
            } else if(temp < mid){
                r = mid;
            } else {
                System.out.println(mid);
                return;
            }
        }
        if (ok(l, nums)) {
            System.out.println(l);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean ok(int mid, int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                res++;
            }
        }
        return res == mid;
    }

    private static int check(int mid, int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                res++;
            }
        }
        return res ;
    }
}
