import java.util.Arrays;

/**
 * 2448. 使数组相等的最小开销
 *
 * @author yangxiaozhuo
 * @date 2022/10/23
 * 给你两个下标从 0开始的数组nums 和cost，分别包含n个正整数。
 * 你可以执行下面操作 任意次：
 * 将nums中 任意元素增加或者减小 1。
 * 对第 i个元素执行一次操作的开销是cost[i]。
 * 请你返回使 nums中所有元素 相等的 最少总开销。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,5,2], cost = [2,3,1,14]
 * 输出：8
 * 解释：我们可以执行以下操作使所有元素变为 2 ：
 * - 增加第 0 个元素 1 次，开销为 2 。
 * - 减小第 1 个元素 1 次，开销为 3 。
 * - 减小第 2 个元素 3 次，开销为 1 + 1 + 1 = 3 。
 * 总开销为 2 + 3 + 3 = 8 。
 * 这是最小开销。
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 5, 2};
        int[] cost = new int[]{2, 3, 1, 14};
        System.out.println(solution.minCost(nums, cost));
    }

    static class Solution {
        public long minCost(int[] nums, int[] cost) {
            int[][] arr = new int[nums.length][2];
            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                arr[i][0] = nums[i];
                arr[i][1] = cost[i];
                sum += cost[i];
            }
            Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
            long target = find(sum, arr);
            long res = 0;
            for (int i = 0; i < cost.length; i++) {
                res = res + Math.abs(nums[i] - target) * cost[i];
            }
            return res;
        }

        public long find(long sum, int[][] arr) {
            long res = 0;
            if (sum % 2 == 0) {
                res = (fun(sum / 2 + 1, arr) + fun(sum / 2, arr)) / 2;
            } else {
                res = fun(sum / 2 + 1, arr);
            }
            return res;
        }

        public long fun(long target, int[][] arr) {
            long temp = 0;
            for (int i = 0; i < arr.length; i++) {
                if (temp + arr[i][1] < target) {
                    temp = temp + arr[i][1];
                } else {
                    return arr[i][0];
                }
            }
            return 0;
        }
    }
}
