import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2022/12/10
 */
public class Main04 {
    public static void main(String[] args) {
//        [5,1,4,1,5,2,5,1,1]
        //[5,1,4,1,5,2,5,1,1]  36

//        int[] ints = new int[]{1, 5, 3, 5, 5};
//        int[] ints2 = new int[]{1, 2, 3, 4, 5};
        int[] ints = new int[]{1,1,1,1,1,2,2,2,2,2,4};
        int[] ints2 = new int[]{1,1,1,1,1,2,2,2,2,2,3};
        int[] t = new int[100009];
        for (int i = 0; i < t.length; i++) {
            t[i] = i + 1;
        }
        Solution solution = new Solution();
        System.out.println(solution.minimumTotalCost(ints, ints2));
    }

    static class Solution {
        public long minimumTotalCost(int[] nums1, int[] nums2) {
            //O(n)
            int[] sum = new int[100010];
            for (int i = 0; i < nums1.length; i++) {
                sum[nums1[i]]++;
            }
            for (int i = 0; i < nums2.length; i++) {
                sum[nums2[i]]++;
                if (sum[nums2[i]] > nums1.length) {
                    return -1;
                }
            }
            int[] need = new int[nums1.length];
            int index = 0;
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] == nums2[i]) {
                    need[index] = i;
                    index++;
                }
            }
            if (index == nums1.length) {
                long t = nums1.length;
                t = t * (t - 1);
                return t / 2L;
            }
            long res = 0;
            for (int i = index - 1; i >= 0; i--) {
                if (need[i] == -1) {
                    continue;
                }
                res = res + fun(i, nums1, nums2, need);
            }
            return res;
        }

        private long fun(int at, int[] nums1, int[] nums2, int[] need) {
            if (need[at] == 0) {
                return 1;
            }
            for (int i = at - 1; i >= 0; i--) {
                if (need[i] == -1) {
                    continue;
                }
                if (nums1[need[at]] != nums1[need[i]]) {
                    swap(nums1, need[at], need[i]);
                    int res = need[i] + need[at];
                    need[i] = -1;
                    return res;
                }
            }
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] != nums1[need[at]] && nums1[need[at]] != nums2[i]) {
                    swap(nums1, need[at], i);
                    return i + need[at];
                }
            }
            return need[at];
        }

        private void swap(int[] nums1, int at, int i) {
            int t = nums1[at];
            nums1[at] = nums1[i];
            nums1[i] = t;
        }
    }
}
