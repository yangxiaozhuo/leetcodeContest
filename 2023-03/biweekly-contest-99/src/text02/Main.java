package text02;

/**
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{58, 42, 8, 75, 28};  //30
    }
}

class Solution {
    static long[] dp = new long[100010];
    static {
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + i * 4 - 4;
        }
    }
    public long coloredCells(int n) {
        return dp[n];
    }
}