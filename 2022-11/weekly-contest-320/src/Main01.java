/**
 * 2475. 数组中不等三元组的数目
 *
 * @author yangxiaozhuo
 * @date 2022/11/20
 */
public class Main01 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int unequalTriplets(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[j]!=nums[i] && nums[i]!=nums[k] && nums[j]!= nums[k]) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
