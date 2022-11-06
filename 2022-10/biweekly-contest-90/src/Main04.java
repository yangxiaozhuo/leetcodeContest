import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2454. 下一个更大元素 IV
 *
 * @author yangxiaozhuo
 * @date 2022/10/29
 * 给你一个下标从 0开始的非负整数数组nums。对于nums中每一个整数，你必须找到对应元素的第二大整数。
 * 如果nums[j]满足以下条件，那么我们称它为nums[i]的第二大整数：
 * j > i
 * nums[j] > nums[i]
 * 恰好存在 一个k满足 i < k < j且nums[k] > nums[i]。
 * 如果不存在nums[j]，那么第二大整数为-1。
 * 比方说，数组[1, 2, 4, 3]中，1的第二大整数是4，2的第二大整数是3，3 和4的第二大整数是-1。
 * 请你返回一个整数数组answer，其中answer[i]是nums[i]的第二大整数。
 *
 * 示例 1：
 * 输入：nums = [2,4,0,9,6]
 * 输出：[9,6,6,-1,-1]
 * 解释：
 * 下标为 0 处：2 的右边，4 是大于 2 的第一个整数，9 是第二个大于 2 的整数。
 * 下标为 1 处：4 的右边，9 是大于 4 的第一个整数，6 是第二个大于 4 的整数。
 * 下标为 2 处：0 的右边，9 是大于 0 的第一个整数，6 是第二个大于 0 的整数。
 * 下标为 3 处：右边不存在大于 9 的整数，所以第二大整数为 -1 。
 * 下标为 4 处：右边不存在大于 6 的整数，所以第二大整数为 -1 。
 * 所以我们返回 [9,6,6,-1,-1] 。
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 4, 0, 9, 6};
        System.out.println(Arrays.toString(solution.secondGreaterElement(nums)));
    }

    static class Solution {
        public int[] secondGreaterElement(int[] nums) {
            int[] res = new int[nums.length];
            Arrays.fill(res, -1);
            if (nums.length < 2) {
                return res;
            }
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(nums[nums.length - 1], 1);
            map.put(nums[nums.length - 2], map.getOrDefault(nums[nums.length - 2], 0) + 1);
            for (int i = nums.length - 3; i >= 0; i--) {
                Map.Entry<Integer, Integer> entry = map.higherEntry(nums[i]);
                if (entry == null) {
                } else {
                    Map.Entry<Integer, Integer> entry1 = map.higherEntry(entry.getKey());
                    if (entry1 == null) {
                        if (entry.getValue() == 1) {

                        } else {
                            res[i] = entry.getKey();
                        }
                    } else {
                        fun(i, nums, res);
                    }
                }
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            return res;
        }

        public void fun(int i, int[] nums, int[] res) {
            int t = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    t++;
                    if (t == 2) {
                        res[i] = nums[j];
                    }
                }
            }
        }
    }
}
