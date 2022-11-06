package three;

/**
 * 907. 子数组的最小值之和
 *
 * @author yangxiaozhuo
 * @date 2022/10/28
 */
public class Main28 {
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            long ans = 0;
            int n = arr.length;
            for (int i = 0; i < n; ++i) {
                int j = i - 1, k = i + 1;
                while (j >= 0 && arr[i] < arr[j]) --j;
                while (k < n && arr[i] <= arr[k]) ++k;
                ans += (long) arr[i] * (i - j) * (k - i);
                ans %= 1000000007;
            }
            return (int) ans;
        }
    }
}
