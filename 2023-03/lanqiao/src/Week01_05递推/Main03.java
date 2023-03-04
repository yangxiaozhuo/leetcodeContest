package Week01_05递推;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 95. 费解的开关
 * https://www.acwing.com/problem/content/97/
 *
 * @author yangxiaozhuo
 * @date 2023/02/20
 */
public class Main03 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            int[][] nums = new int[5][5];
            for (int i = 0; i < nums.length; i++) {
                String s = in.readLine();
                for (int j = 0; j < s.length(); j++) {
                    nums[i][j] = s.charAt(j) - '0';
                }
            }
            fun(nums);
            in.readLine();
        }
    }

    private static void fun(int[][] nums) {
        int res = 10;
        for (int i = 0; i <= 31; i++) {
            int t = 0;
            int[][] ints = copyOf(nums);
            for (int j = 0; j < 5; j++) {
                if (((i >> j) & 1) == 1) {
                    t++;
                    change(ints, 0, j);
                }
            }
            int temp = make(ints);
            if (temp != -1) {
                res = res == -1 ? temp + t : Math.min(temp + t, res);
            }
        }
        if (res > 6) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    private static int[][] copyOf(int[][] nums) {
        int[][] res = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                res[i][j] = nums[i][j];
            }
        }
        return res;
    }

    private static int make(int[][] ints) {
        int t = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (ints[i - 1][j] == 0) {
                    change(ints, i, j);
                    t++;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (ints[4][i] == 0) {
                return -1;
            }
        }
        return t;
    }

    private static void change(int[][] ints, int i, int j) {
        if (j > 0) {
            ints[i][j - 1] = 1 - ints[i][j - 1];
        }
        ints[i][j] = 1 - ints[i][j];
        if (j < 4) {
            ints[i][j + 1] = 1 - ints[i][j + 1];
        }
        if (i > 0) {
            ints[i - 1][j] = 1 - ints[i - 1][j];
        }
        if (i < 4) {
            ints[i + 1][j] = 1 - ints[i + 1][j];
        }
    }
}
