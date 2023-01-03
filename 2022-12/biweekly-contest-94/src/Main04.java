import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author yangxiaozhuo
 * @date 2022/12/24
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAnagrams("too hot"));
    }

    static class Solution {
        BigDecimal[] dp = new BigDecimal[100000];
        public int countAnagrams(String s) {
            BigDecimal big = new BigDecimal(1);
            int mod = 100_000_0007;
            String[] s1 = s.split(" ");
            for (String ss : s1) {
                int[] nums = fun(ss);
                big = big.multiply(jiec(ss.length()));
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] > 1) {
                        big = big.divide(jiec(nums[i]));
                    }
                }
            }
            BigDecimal[] bigDecimals = big.divideAndRemainder(BigDecimal.valueOf(mod));
            return Integer.parseInt(bigDecimals[1].toString());
        }

        private BigDecimal jiec(int length) {
            if (dp[length]!=null){
                return dp[length];
            }
            if (length == 1) {
                return BigDecimal.valueOf(1);
            }
            BigDecimal multiply = BigDecimal.valueOf(length).multiply(jiec(length - 1));
            dp[length] = multiply;
            return multiply;
        }

        private int[] fun(String ss) {
            int[] ints = new int[26];
            for (char c : ss.toCharArray()) {
                ints[c - 'a']++;
            }
            return ints;
        }
    }
}
