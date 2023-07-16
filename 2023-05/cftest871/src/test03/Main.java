package test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/05/06
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int[][] nums = new int[n][3];
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                nums[i][0] = Integer.parseInt(s[0]);
                nums[i][1] = s[1].charAt(0) - '0';
                nums[i][2] = s[1].charAt(1) - '0';
            }
            System.out.println(fun(nums));
        }
    }

    private static int fun(int[][] nums) {
        int a = 10000000;
        int b = 10000000;
        int ab = 10000000;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][1] == 1 && nums[i][2] == 1) {
                ab = Math.min(ab, nums[i][0]);
                continue;
            }
            if (nums[i][1] == 1) {
                a = Math.min(a, nums[i][0]);
            }
            if (nums[i][2] == 1) {
                b = Math.min(b, nums[i][0]);
            }
        }
        if ((a == 10000000 || b == 10000000) && ab == 10000000) {
            return -1;
        }
        return Math.min(a+b,ab);
    }
}


