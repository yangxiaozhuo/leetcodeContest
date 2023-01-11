import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/01/07
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{1};
        System.out.println(solution.maxPower(ints, 0, 0));
    }

    static class Solution {
        public long maxPower(int[] stations, int r, int k) {
            if (stations.length == 1) {
                return stations[0] + k;
            }
            long[] sum = new long[stations.length];
            long pre = 0;
            for (int i = 0; i <= r; i++) {
                pre = pre + stations[i];
            }
            sum[0] = pre;
            long right = Long.MAX_VALUE / 100000;
            long left = pre;
            for (int i = 1; i < stations.length; i++) {
                if (i + r < stations.length) {
                    pre = pre + stations[i + r];
                }
                if (i - r - 1 >= 0) {
                    pre = pre - stations[i - r - 1];
                }
                sum[i] = pre;
                left = Math.min(left, sum[i]);
            }
            if (k == 0) {
                return left;
            }
            if (r == stations.length - 1) {
                return left + k;
            }
            while (left < right) {
                long mid = left + ((right- left + 1) >> 1);
                if (fun(mid, Arrays.copyOf(sum, sum.length), k, r)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private boolean fun(long mid, long[] sum, int k, int r) {/*
        long had = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] < mid) {
                long t = mid - sum[i];
                had = had + t;
                if (had > k) {
                    return false;
                }
                for (int j = i; j < Math.min(sum.length, i + 1 + 2 * r); j++) {
                    sum[j] += t;
                }
            }
        }
        return true;*/
            //优化
            long had = 0;
            long[] ttt = new long[sum.length + 1];
            long pre = 0;
            for (int i = 0; i < sum.length; i++) {
                pre = pre + ttt[i];
                if (sum[i] + pre < mid) {
                    long t = mid - sum[i] - pre;
                    had = had + t;
                    if (had > k) {
                        return false;
                    }
                    ttt[i] += t;
                    ttt[Math.min(sum.length, i + 1 + 2 * r)] -= t;
                    pre += t;
                }
            }
            return true;
        }
    }
}
