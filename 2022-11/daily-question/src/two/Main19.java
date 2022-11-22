package two;

/**
 * 1732. 找到最高海拔
 *
 * @author yangxiaozhuo
 * @date 2022/11/19
 */
public class Main19 {
    class Solution {
        public int largestAltitude(int[] gain) {
            int max = 0;
            int sum = 0;
            for (int i : gain) {
                sum += i;
                max = Math.max(max, sum);
            }
            return max;
        }
    }
}
