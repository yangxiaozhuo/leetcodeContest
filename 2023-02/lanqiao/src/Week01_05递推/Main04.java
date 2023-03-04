package Week01_05递推;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 116. 飞行员兄弟
 * https://www.acwing.com/problem/content/118/
 *
 * @author yangxiaozhuo
 * @date 2023/02/20
 */
public class Main04 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] nums = new int[4][4];
        for (int i = 0; i < nums.length; i++) {
            String s = in.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '+') {
                    nums[i][j] = 0;
                } else {
                    nums[i][j] = 1;
                }
            }
        }
        fun(nums);
    }

    private static void fun(int[][] nums) {
        int res = 0;
        int min = 20;
        for (int i = 0; i < (1 << 16); i++) {
            int[][] ints = copyOf(nums);
            int t = 0;
            for (int j = 0; j < 16; j++) {
                if (((i >> j) & 1) == 1) {
                    change(ints, j / 4, j % 4);
                    t++;
                }
            }
            if (check(ints)) {
                if (min > t) {
                    min = t;
                    res = i;
                }
            }
        }
        System.out.println(min);
        for (int j = 0; j < 16; j++) {
            if (((res >> j) & 1) == 1) {
                int r = j / 4;
                int l = j % 4;
                System.out.println((r + 1) + " " + (l + 1));
            }
        }
    }

    private static boolean check(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void change(int[][] ints, int i, int j) {
        for (int k = 0; k < 4; k++) {
            ints[i][k] = 1 - ints[i][k];
        }
        for (int k = 0; k < 4; k++) {
            ints[k][j] = 1 - ints[k][j];
        }
        ints[i][j] = 1 - ints[i][j];
    }

    private static int[][] copyOf(int[][] nums) {
        int[][] res = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(nums[i], 0, res[i], 0, 4);
        }
        return res;
    }
}
