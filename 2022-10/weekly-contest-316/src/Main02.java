/**
 * 2447. 最大公因数等于 K 的子数组数目
 *
 * @author yangxiaozhuo
 * @date 2022/10/23
 * 给你一个整数数组nums和一个整数k ，请你统计并返回 nums的子数组中元素的最大公因数等于 k的子数组数目。
 * 子数组 是数组中一个连续的非空序列。
 * 数组的最大公因数是能整除数组中所有元素的最大整数。
 * <p>
 * 示例 1：
 * 输入：nums = [9,3,1,2,6,3], k = 3
 * 输出：4
 * 解释：nums 的子数组中，以 3 作为最大公因数的子数组如下：
 * - [9,3,1,2,6,3]
 * - [9,3,1,2,6,3]
 * - [9,3,1,2,6,3]
 * - [9,3,1,2,6,3]
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{9, 3, 1, 2, 6, 3};
        System.out.println(solution.subarrayGCD(nums, 3));
    }

    static class Solution {
        public int subarrayGCD(int[] nums, int k) {
            int res = 0;
            int l = 0;
            int r = 0;
            while (r < nums.length) {
                while (r < nums.length && nums[r] % k == 0) {
                    r++;
                }
                if (r > l) {
                    res = res + fun(r, l, nums, k);  //l 到 r-1都是k的倍数
                }
                while (r < nums.length && nums[r] % k != 0) {
                    r++;
                }
                l = r;
            }
            return res;
        }

        //计算l 到r -1 中有多少符合的情况。
        private int fun(int r, int l, int[] nums, int k) {
            int res = 0;
            for (int star = l; star < r; star++) {
                for (int end = star; end < r; end++) {
                    if (nums[end] == k) {
                        res = res + r - end;
                        break;
                    }
                    if (end == star && nums[star] == k) {
                        res++;
                    }
                    if (check(nums, star, end, k)) {
                        res = res + r - end;
                        break;
                    }
                }
            }
            return res;
        }

        private boolean check(int[] nums, int star, int end, int k) {
            for (int i = star; i <= end; i++) {
                for (int j = star + 1; j <= end; j++) {
                    if (way(nums[i], nums[j]) == k) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static int way(int m, int n) {
            if (m == n) {
                return n;
            }
            if (m > n && m % n == 0) {
                return n;
            } else {
                return way(n, (m % n));
            }
        }
    }
}
