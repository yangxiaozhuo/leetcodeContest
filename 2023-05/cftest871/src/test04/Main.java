package test04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatCodePointException;

/**
 * @author yangxiaozhuo
 * @date 2023/05/06
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String[] s = in.readLine().split(" ");
            int nums = Integer.parseInt(s[0]);
            int target = Integer.parseInt(s[1]);
            if (fun(nums, target)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean fun(int nums, int target) {
        if (target == nums) {
            return true;
        }
        if (target > nums) {
            return false;
        }
        if (nums % 3 != 0) {
            return false;
        }
        int t = nums / 3;
        return fun(t * 2, target) || fun(t, target);
    }
}

