//2453. 摧毁一系列目标

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给你一个下标从 0开始的数组nums，它包含若干正整数，表示数轴上你需要摧毁的目标所在的位置。同时给你一个整数space。
 * 你有一台机器可以摧毁目标。给机器 输入nums[i]，这台机器会摧毁所有位置在nums[i] + c * space的目标，其中c是任意非负整数。你想摧毁nums中 尽可能多的目标。
 * 请你返回在摧毁数目最多的前提下，nums[i]的 最小值。
 *
 * 示例 1：
 * 输入：nums = [3,7,8,1,1,5], space = 2
 * 输出：1
 * 解释：如果我们输入 nums[3] ，我们可以摧毁位于 1,3,5,7,9,... 这些位置的目标。
 * 这种情况下， 我们总共可以摧毁 5 个目标（除了 nums[2]）。
 * 没有办法摧毁多于 5 个目标，所以我们返回 nums[3] 。
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,7,8,1,1,5};
        System.out.println(solution.destroyTargets(nums,2));
    }
    static class Solution {
        public int destroyTargets(int[] nums, int space) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i] % space, map.getOrDefault(nums[i] % space, 0) + 1);
            }
            HashSet<Integer> set = new HashSet<>();
            int max = 0;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    set.clear();
                    set.add(entry.getKey());
                } else if(entry.getValue() == max) {
                    set.add(entry.getKey());
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if(set.contains(nums[i] % space)) {
                    res = Math.min(res, nums[i]);
                }
            }
            return res;
        }
    }
}
