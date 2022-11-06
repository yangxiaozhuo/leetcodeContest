/**
 * 2430. 对字母串可执行的最大删除数
 *
 * @author yangxiaozhuo
 * @date 2022/10/02
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以：
 * 删除 整个字符串 s ，或者
 * 对于满足1 <= i <= s.length / 2 的任意 i ，如果 s 中的 前 i 个字母和接下来的 i 个字母 相等 ，删除 前 i 个字母。
 * 例如，如果 s = "ababc" ，那么在一步操作中，你可以删除 s 的前两个字母得到 "abc" ，因为 s 的前两个字母和接下来的两个字母都等于 "ab" 。
 * 返回删除 s 所需的最大操作数。
 * <p>
 * 示例 1：
 * 输入：s = "abcabcdabc"
 * 输出：2
 * 解释：
 * - 删除前 3 个字母（"abc"），因为它们和接下来 3 个字母相等。现在，s = "abcdabc"。
 * - 删除全部字母。
 * 一共用了 2 步操作，所以返回 2 。可以证明 2 是所需的最大操作数。
 * 注意，在第二步操作中无法再次删除 "abc" ，因为 "abc" 的下一次出现并不是位于接下来的 3 个字母。
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deleteString("abcabcdabc"));
    }

    static class Solution {
        public int deleteString(String s) {
            char[] chars = s.toCharArray();
            int[] dp = new int[chars.length];
            // Arrays.fill(dp, 1);
            dp[dp.length - 1] = 1;
            int max = 0;
            for (int i = dp.length - 2; i >= 0; i--) {
                dp[i] = 1;
                for (int j = i; j < (dp.length + i >> 1); j++) {
                    if (check(i, j, chars)) {
                        dp[i] = Math.max(dp[i], 1 + dp[j + 1]);
                        if (dp[i] > max) break;
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return dp[0];
        }

        private boolean check(int i, int j, char[] chars) {
            int l = i;
            int r = j + 1;
            while (l <= j) {
                if (chars[l] != chars[r]) {
                    return false;
                }
                r++;
                l++;
            }
            return true;
        }
    }
}
