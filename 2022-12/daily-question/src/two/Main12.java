package two;

import java.util.Random;

/**
 * 1781. 所有子字符串美丽值之和
 *
 * @author yangxiaozhuo
 * @date 2022/12/12
 */
public class Main12 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 300; i++) {
            int i1 = random.nextInt(26);
            System.out.print((char) ('a' + i1));
        }
        Solution solution = new Solution();
//        System.out.println(solution.beautySum("aabcb"));  //5
//        System.out.println(solution.beautySum("aabcbaa")); //17
    }

    static class Solution {
        public int beautySum(String s) {
            int res = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int[] dp = new int[26];
                int max = 0;
                int min = 0;
                for (int j = i; j < chars.length; j++) {
                    char aChar = chars[j];
                    int i1 = dp[aChar - 'a'];
                    dp[aChar - 'a']++;
                    if (i1 == min) {
                        min = findMid(dp);
                    }
                    if (i1 < min) {
                        min = i1 + 1;
                    }
                    if (i1 == max) {
                        max = i1 + 1;
                    }
                    res = res + max - min;
                }
            }
            return res;
        }

        private int findMid(int[] dp) {
            int res = 500;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] != 0) {
                    res = Math.min(dp[i], res);
                }
            }
            return res;
        }
    }
}
