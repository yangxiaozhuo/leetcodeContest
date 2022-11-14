import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * 2462. 雇佣 K 位工人的总代价
 *
 * @author yangxiaozhuo
 * @date 2022/11/06
 */
public class Main03 {
    public static void main(String[] args) {
        int[] nums = new int[]{31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};
        Solution solution = new Solution();
        System.out.println(solution.totalCost(nums, 11, 2));
    }

    static class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            long res = 0;
            if (costs.length <= candidates * 2) {
                Arrays.sort(costs);
                for (int i = 0; i < k; i++) {
                    res = res + costs[i];
                }
                return res;
            }

            PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
            PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
            int left = 0;
            int right = costs.length - 1;
            for (left = 0; left < candidates; left++) {
                leftQueue.add(costs[left]);
            }
            for (int i = 0; i < candidates; i++) {
                rightQueue.add(costs[right]);
                right--;
            }
            while (left <= right && k > 0) {
                if(leftQueue.peek() <= rightQueue.peek()) {
                    res = res + leftQueue.poll();
                    leftQueue.add(costs[left]);
                    left++;
                }else {
                    res = res + rightQueue.poll();
                    rightQueue.add(costs[right]);
                    right--;
                }
                k--;
            }

            if (k > 0) {
                leftQueue.addAll(rightQueue);
                while (k > 0) {
                    k--;
                    res += leftQueue.poll();
                }
            }
            return res;
        }
    }
}
