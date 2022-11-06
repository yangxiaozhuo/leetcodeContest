import java.util.HashSet;

/**
 * 2442. 反转之后不同整数的数目
 *
 * @author yangxiaozhuo
 * @date 2022/10/16
 * 给你一个由 正 整数组成的数组 nums 。
 * 你必须取出数组中的每个整数，反转其中每个数位，并将反转后得到的数字添加到数组的末尾。这一操作只针对 nums 中原有的整数执行。
 * 返回结果数组中 不同 整数的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [1,13,10,12,31]
 * 输出：6
 * 解释：反转每个数字后，结果数组是 [1,13,10,12,31,1,31,1,21,13] 。
 * 反转后得到的数字添加到数组的末尾并按斜体加粗表示。注意对于整数 10 ，反转之后会变成 01 ，即 1 。
 * 数组中不同整数的数目为 6（数字 1、10、12、13、21 和 31）。
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 13, 10, 12, 31};
        System.out.println(solution.countDistinctIntegers(nums));
    }

    static class Solution {
        public int countDistinctIntegers(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                sb = sb.reverse();
                set.add(nums[i]);
                set.add(Integer.parseInt(sb.toString()));
            }
            return set.size();
        }
    }
}
