package three;

/**
 * 795. 区间子数组个数
 *
 * @author yangxiaozhuo
 * @date 2022/11/24
 */
public class Main24 {
    public static void main(String[] args) {
        int[] ints = new int[]{2, 9, 2, 5, 6};

    }
    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            return numSubarrayBoundedMax(nums,right) - numSubarrayBoundedMax(nums,left - 1);
        }

        private int numSubarrayBoundedMax(int[] nums, int left) {
            int res = 0;
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <= left) {
                    temp++;
                } else {
                    temp = 0;
                }
                res += temp;

            }
            return res;
        }
    }

    //硬算
    static class Solution2 {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] >= left && nums[i] <= right) {
                    nums[i] = 1;
                } else if(nums[i] <left){
                    nums[i] = 0;
                } else {
                    nums[i] = -1;
                }
            }
            int res = 0;
            int l = 0;
            int r = 0;
            while(r < nums.length) {
                while(r < nums.length && nums[r] == -1) {
                    r++;
                }
                l = r;
                while(r < nums.length && nums[r] != -1) {
                    r++;
                }
                //求l到r（不算r）之间，有多少符合要求的
                res = res + fun(nums, l ,r);
            }
            return res;
        }

        private int fun(int[] nums, int l, int r) {
            int[] preSum = new int[r - l + 1];
            boolean flag = true;
            for (int i = l; i < r; i++) {
                preSum[i + 1 - l] = preSum[i-l] + nums[i];
                if(nums[i] == 0) {
                    flag = false;
                }
            }
            if(flag == true) {
                long len = r - l;
                return (int)((len + 1) * len / 2);
            }
            int res = 0;
            for (int i = l; i < r; i++) {
                for (int j = i; j < r; j++) {
                    if (preSum[j - l + 1] - preSum[i - l] != 0) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
