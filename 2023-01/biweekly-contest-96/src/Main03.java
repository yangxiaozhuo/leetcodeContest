import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/01/21
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 100000; i >= 1; i--) {
            System.out.printf(100000+",");
        }
//        int[] ints = new int[]{4, 2, 3, 1, 1};
//        int[] ints2 = new int[]{7, 5, 10, 9, 6};
//        System.out.println(solution.maxScore(ints, ints2, 3));
    }

    static class Solution {
        public long maxScore(int[] nums1, int[] nums2, int k) {
            long res = 0;
            if (k == 1) {
                for (int i = 0; i < nums1.length; i++) {
                    res = Math.max(res, nums1[i] * (long) nums2[i]);
                }
                return res;
            }
            int[][] nums = new int[nums1.length][2];
            for (int i = 0; i < nums1.length; i++) {
                nums[i][0] = nums1[i];
                nums[i][1] = nums2[i];
            }
            Arrays.sort(nums, (o1, o2) -> o2[1] - o1[1]);
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i][0];
                queue.add(nums[i][0]);
            }
            res = sum * nums[k - 1][1];
            for (int i = k; i < nums.length; i++) {
                queue.offer(nums[i][0]);
                sum = sum + nums[i][0] - queue.poll();
                res = Math.max(res, sum * nums[i][1]);
            }
            return res;
        }
    }
}
