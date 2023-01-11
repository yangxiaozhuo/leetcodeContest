import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/01/08
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
    static class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
            long res = 0;
            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
            }
            while (k-- > 0) {
                Integer poll = queue.poll();
                res += poll;
                queue.add((poll + 2) / 3);
            }
            return res;
        }
    }
}
