package acwing.Week4Day02;

/**
 * https://www.acwing.com/problem/content/4513/
 *
 * @author yangxiaozhuo
 * @date 2023/01/19
 */

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);
        int S = Integer.parseInt(s[2]);
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.readLine());
        }
        int[][] nums = new int[S + 1][S + 1];
        for (int i = 0; i < S + 1; i++) {
            s = in.readLine().split(" ");
            for (int j = 0; j < S + 1; j++) {
                nums[i][j] = Integer.parseInt(s[j]);
            }
        }
        int res = 0;
        for (String str : set) {
            if (check(str, set, nums, L)) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static boolean check(String str, HashSet<String> set, int[][] nums, int L) {
        String[] s = str.split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int ta = a + nums.length - 1 - i;
                int tb = b + j;
                if (ta > L || tb > L) {
                    return false;
                }
                if (nums[i][j] == 1) {
                    if (!set.contains(ta + " " + tb)) {
                        return false;
                    }
                } else {
                    if (set.contains(ta + " " + tb)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}