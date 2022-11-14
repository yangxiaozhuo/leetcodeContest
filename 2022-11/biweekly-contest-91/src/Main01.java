import java.util.Arrays;
import java.util.HashSet;

/**
 * 6237. 不同的平均值数目
 *
 * @author yangxiaozhuo
 * @date 2022/11/12
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{9, 5, 7, 8, 7, 9, 8, 2, 0, 7};
        System.out.println(solution.distinctAverages(ints));
    }

    static class Solution {
        public int distinctAverages(int[] nums) {
            HashSet<Double> doubles = new HashSet<>();
            Arrays.sort(nums);
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                doubles.add((((double) nums[l] + nums[r]) / 2));
                l++;
                r--;
            }
            return doubles.size();
        }
    }
}
