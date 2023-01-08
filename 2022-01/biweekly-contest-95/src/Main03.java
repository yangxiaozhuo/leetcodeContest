import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/01/07
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[10000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        System.out.println(Arrays.toString(ints));
    }

    static class Solution {
        public int xorBeauty(int[] nums) {
            int[] dp = new int[31];
            for (int num : nums) {
                fun(dp, num);
            }
            int res = 0;
            for (int i = dp.length - 1; i >= 0; i--) {
                if (dp[i] % 2 != 0) {
                    res = res + 1;
                }
                res = res * 2;
            }
            return res;
        }

        private void fun(int[] dp, int num) {
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i) & 1;
                dp[i] += bit;
            }
        }
    }
}
