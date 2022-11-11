/**
 * 2406. 将区间分为最少组数
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main03 {
    class Solution {
        public int minGroups(int[][] intervals) {
            int[] num = new int[1000002];  //num[i] 记录了 0到i-1 要加num[i]次
            for (int i = 0; i < intervals.length; i++) {
                num[intervals[i][1] + 1]++;
                num[intervals[i][0]]--;
            }
            int max = 0;
            num[0] = 0;
            int[] res = new int[1000002];
            for (int i = 1000000; i >= 0; i--) {
                res[i] = res[i + 1] + num[i + 1];
                max = Math.max(max, res[i]);
            }
            return max;
        }
    }
}
