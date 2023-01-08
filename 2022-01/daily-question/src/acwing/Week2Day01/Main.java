package acwing.Week2Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * https://www.acwing.com/problem/content/description/4648/
 *
 * @author yangxiaozhuo
 * @date 2023/01/03
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        long x = Integer.parseInt(s[2]);
        int[] dp = new int[n];
        s = in.readLine().split(" ");
        long[] nums = new long[n];
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Long.parseLong(s[i]);
        }
        dp[dp.length - 1] = Integer.MAX_VALUE;
        map.put(nums[nums.length - 1], nums.length - 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            long t = x ^ nums[i];
            if (map.containsKey(t)) {
                dp[i] = Math.min(map.get(t), dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
            map.put(nums[i], i);
        }
        while (m-- > 0) {
            s = in.readLine().split(" ");
            int l = Integer.parseInt(s[0]) - 1;
            int r = Integer.parseInt(s[1]) - 1;
            if (dp[l] <= r) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
