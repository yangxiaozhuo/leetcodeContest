package one;

/**
 * 1802. 有界数组中指定下标处的最大值
 *
 * @author yangxiaozhuo
 * @date 2023/01/04
 */
public class Main04 {
    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int l = 0;
            int r = maxSum;
            while (l < r) {
                int mid = l + ((r - l + 1) >> 1);
                if(fun(mid, index, n) > maxSum) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            return l;
        }

        private long fun(int mid, int index, int n) {
            long res = 0;
            if (index + 1 >= mid) {
                res = res + (1L + mid) * mid / 2;
                res = res + index - mid + 1;
            } else {
                res = res + (mid - index + 1L + mid) * (index + 1) / 2;
            }
            if(n - index + 1 >= mid) {
                res = res + (1L + mid) * mid / 2;
                res = res + n - index + 1 - mid;
            } else {
                res = res + (mid + index - n + 1L + mid) * (n - index) / 2;
            }
            return res;
        }
    }
}
