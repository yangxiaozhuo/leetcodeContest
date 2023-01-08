package acwing.Week1Day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/description/4369/
 *
 * @author yangxiaozhuo
 * @date 2023/01/07
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] s = in.readLine().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            boolean flag = true;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(0);
            } else {
                System.out.println(fun(nums));
            }
        }
    }

    private static int fun(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int i = nums.length; i > 0; i--) {
            if (sum % i != 0) {
                continue;
            }
            int l = 0;
            int r = 0;
            int target = sum / i;
            int dui = 0;
            while (r <= nums.length) {
                while (r <= nums.length && preSum[r] - preSum[l] < target) {
                    r++;
                }
                if (r == nums.length + 1) {
                    if (dui + 1 == i) {
                        return dui;
                    } else {
                        break;
                    }
                }
                if (preSum[r] - preSum[l] > target) {
                    break;
                } else {
                    dui++;
                    l = r;
                }
            }
            if (dui == i) {
                return nums.length - dui;
            }
        }
        return nums.length - 1;
    }
}
