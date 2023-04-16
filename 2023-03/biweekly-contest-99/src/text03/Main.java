package text03;

import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{1, 3}, {10, 20}, {2, 5}, {4, 8}};
        System.out.println(solution.countWays(ints));
    }
}

class Solution {
    static int mod = 1000_000_007;
    static long[] dp = new long[100010];
    static {
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = (dp[i / 2] * dp[i / 2]) % mod;
            } else {
                dp[i] = (dp[i / 2] * dp[i / 2] * 2) % mod;
            }
        }
    }
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int num = 0;
        int index = 0;
        while (index < ranges.length) {
            num++;
            int max = ranges[index][1];
            while (index < ranges.length - 1 && ranges[index + 1][0] <= max) {
                max = Math.max(max, ranges[index + 1][1]);
                index++;
            }
            index++;
        }
        return (int)dp[num];
    }
}