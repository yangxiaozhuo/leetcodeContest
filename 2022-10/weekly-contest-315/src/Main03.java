/**
 * 2443. 反转之后的数字和
 *
 * @author yangxiaozhuo
 * @date 2022/10/16
 * 给你一个 非负 整数 num 。如果存在某个 非负 整数 k 满足 k + reverse(k) = num  ，则返回 true ；否则，返回 false 。
 * reverse(k) 表示 k 反转每个数位后得到的数字。
 * <p>
 * 示例 1：
 * 输入：num = 443
 * 输出：true
 * 解释：172 + 271 = 443 ，所以返回 true 。
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfNumberAndReverse(443));
    }

    static class Solution {
        public boolean sumOfNumberAndReverse(int num) {
            if (num == 0) return true;
            for (int i = 1; i < num; i++) {
                if (i + reverse(i) == num) {
                    return true;
                }
            }
            return false;
        }

        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                x /= 10;
            }
            return res;
        }
    }
}
