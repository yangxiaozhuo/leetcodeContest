import java.util.ArrayList;
import java.util.List;

/**
 * 2420. 找到所有好下标
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main03 {
    class Solution {
        int num;

        public List<Integer> goodIndices(int[] nums, int k) {
            List<Integer> res = new ArrayList<>();
            if (k==1) {
                for (int i = 1; i < nums.length - 1; i++) {
                    res.add(i);
                }
                return res;
            }
            int left = k;
            int right = nums.length - k - 1;
            if (right < left) return res;
            while (left <= right) {
                boolean fun = fun(nums, left, k);
                if (fun) {
                    res.add(left);
                    while (left <= right && fun && left + k + 1 < nums.length - 1) {
                        fun = nums[left - 1] >= nums[left] && nums[left + k] <= nums[left + k + 1];
                        left++;
                        if (fun) {
                            res.add(left);
                        }
                    }
                    left++;
                } else {
                    if (num < left) {
                        left = num + k + 1;
                    } else {
                        left = num - 1;
                    }
                }

            }
            return res;
        }

        public boolean fun(int[] nums, int index, int k) {
            for (int i = 1; i < k; i++) {
                if (!(nums[index + i + 1] >= nums[index + i])) {
                    num = index + i + 1;
                    return false;
                }
                if (!(nums[index - i - 1] >= nums[index - i])) {
                    num = index - i - 1;
                    return false;
                }
            }
            return true;
        }
    }
}
