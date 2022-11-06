/**
 * 2457. 美丽整数的最小增量
 *
 * @author yangxiaozhuo
 * @date 2022/10/30
 * 给你两个正整数 n 和 target 。
 * 如果某个整数每一位上的数字相加小于或等于 target ，则认为这个整数是一个 美丽整数 。
 * 找出并返回满足 n + x 是 美丽整数 的最小非负整数 x 。生成的输入保证总可以使 n 变成一个美丽整数。
 *
 * 示例 1：
 * 输入：n = 16, target = 6
 * 输出：4
 * 解释：最初，n 是 16 ，且其每一位数字的和是 1 + 6 = 7 。在加 4 之后，n 变为 20 且每一位数字的和变成 2 + 0 = 2 。可以证明无法加上一个小于 4 的非负整数使 n 变成一个美丽整数。
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeIntegerBeautiful(16,6));
    }
    static class Solution {
        public long makeIntegerBeautiful(long n, int target) {
            StringBuilder sb = new StringBuilder();
            sb.append(n);
            int sum = 0;
            for (int i = 0; i < sb.length(); i++) {
                sum = sum + (int)sb.charAt(i) - '0';
            }
            if (sum <= target) {
                return 0;
            }
            sum = 0;
            boolean flag = true;
            StringBuilder substring = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                sum = sum + (int)(sb.charAt(i) -'0');
                if(sum > target - 1) {
                    flag = false;
                    substring = new StringBuilder(sb.substring(0, i));
                    break;
                }
            }
            if (flag) {
                return 0;
            }
            long max;
            if (substring.length() > 0) {
                max = Long.parseLong(substring.toString()) + 1;
            } else {
                max = 1;
            }
            while (max < n) {
                max = max * 10;
            }
            return max - n;
        }
    }
}
