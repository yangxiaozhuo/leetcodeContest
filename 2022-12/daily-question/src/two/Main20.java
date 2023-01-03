package two;

/**
 * 1760. 袋子里最少数目的球
 * @author yangxiaozhuo
 * @date 2022/12/26
 */
public class Main20 {
    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            int l = 1;
            int r = max;
            while (l < r) {
                int mid = l + r >> 1;
                if (fun(nums, mid) > maxOperations) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }

        private int fun(int[] nums, int mid) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > mid) {
                    res = nums[i] / mid + res;
                    res--;
                    if (nums[i] % mid > 0) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
