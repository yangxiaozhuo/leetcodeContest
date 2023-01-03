package three;

import java.util.ArrayList;
import java.util.List;

/**
 * 2032. 至少在两个数组中出现的值
 *
 * @author yangxiaozhuo
 * @date 2022/12/29
 */
public class Main29 {
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            ArrayList<Integer> res = new ArrayList();
            int[] nums = new int[101];
            int[] sums = new int[101];
            for (int n : nums1) {
                nums[n]++;
                if (nums[n] == 1) {
                    sums[n]++;
                }
            }
            nums = new int[101];
            for (int n : nums2) {
                nums[n]++;
                if (nums[n] == 1) {
                    sums[n]++;
                }
            }
            nums = new int[101];
            for (int n : nums3) {
                nums[n]++;
                if (nums[n] == 1) {
                    sums[n]++;
                }
            }
            for (int i = 0; i < sums.length; i++) {
                if (sums[i] >= 2) {
                    res.add(i);
                }
            }
            return res;
        }
    }
}
