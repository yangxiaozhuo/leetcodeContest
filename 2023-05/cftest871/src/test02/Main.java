package test02;

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
            String s = in.readLine();
            String[] s2 = in.readLine().split(" ");
            int[] ints = new int[s2.length];
            for (int i = 0; i < s2.length; i++) {
                ints[i] = Integer.parseInt(s2[i]);
            }
            System.out.println(fun(ints));
        }
    }

    private static int fun(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i;
                for (; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        break;
                    }
                }
                res = Math.max(res, j - i);
            }
        }
        return res;
    }
}


