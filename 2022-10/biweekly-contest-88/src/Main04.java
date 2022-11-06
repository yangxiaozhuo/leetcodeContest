/**
 * 2426. 满足不等式的数对数目
 *
 * @author yangxiaozhuo
 * @date 2022/10/01
 * <p>
 * 给你两个下标从 0开始的整数数组nums1 和nums2，两个数组的大小都为n，同时给你一个整数diff，统计满足以下条件的数对(i, j)：
 * 0 <= i < j <= n - 1且
 * nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
 * 请你返回满足条件的 数对数目。
 * <p>
 * 示例 1：
 * 输入：nums1 = [3,2,5], nums2 = [2,2,1], diff = 1
 * 输出：3
 * 解释：
 * 总共有 3 个满足条件的数对：
 * 1. i = 0, j = 1：3 - 2 <= 2 - 2 + 1 。因为 i < j 且 1 <= 1 ，这个数对满足条件。
 * 2. i = 0, j = 2：3 - 5 <= 2 - 1 + 1 。因为 i < j 且 -2 <= 2 ，这个数对满足条件。
 * 3. i = 1, j = 2：2 - 5 <= 2 - 1 + 1 。因为 i < j 且 -3 <= 2 ，这个数对满足条件。
 * 所以，我们返回 3 。
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{3, 2, 5};
        int[] nums2 = new int[]{2, 2, 1};
        System.out.println(solution.numberOfPairs(nums1, nums2, 1));
    }

    static class Solution {
        public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
            int[] arr = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                arr[i] = nums1[i] - nums2[i];
            }
            long res = 0;
            res = fun(arr, 0, arr.length - 1, diff);
            return res;
        }

        private long fun(int[] arr, int l, int r, int diff) {
            if (l == r) {
                return 0;
            }
            int mid = l + r >> 1;
            long res = fun(arr, l, mid, diff) + fun(arr, mid + 1, r, diff);
            for (int i = l; i <= mid; i++) {
                for (int j = mid + 1; j <= r; j++) { //两边一起
                    if (arr[j] >= arr[i] - diff) {
                        res = res + r - j + 1;
                        break;
                    }
                    if (arr[r - j + mid + 1] < arr[i] - diff) {
                        res = res + j - mid - 1;
                        break;
                    }
                }
            }
            int cur = 0;
            int[] ints = new int[r - l + 1];
            int left = l;
            int right = mid + 1;
            while (left <= mid && right <= r) {
                if (arr[left] < arr[right]) {
                    ints[cur++] = arr[left++];
                } else {
                    ints[cur++] = arr[right++];
                }
            }
            for (int i = left; i <= mid; i++) {
                ints[cur++] = arr[i];
            }
            for (int i = right; i <= r; i++) {
                ints[cur++] = arr[i];
            }
            for (int i = 0; i < ints.length; i++) {
                arr[l + i] = ints[i];
            }
            return res;
        }
    }
}
