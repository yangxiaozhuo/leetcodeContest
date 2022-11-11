/**
 * 2412. 完成所有交易的初始最少钱数
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main04 {
    class Solution {
        public long minimumMoney(int[][] transactions) {
            long p = 0;
            for (int i = 0; i < transactions.length; ++i) {
                if (transactions[i][1] < transactions[i][0]) {
                    p += transactions[i][0] - transactions[i][1];
                }
            }
            long ans = 0;
            for (int i = 0; i < transactions.length; ++i) {
                if (transactions[i][1] < transactions[i][0]) {
                    ans = Math.max(ans, p + transactions[i][1]);
                } else {
                    ans = Math.max(ans, p + transactions[i][0]);
                }
            }
            return ans;
        }
    }
}
