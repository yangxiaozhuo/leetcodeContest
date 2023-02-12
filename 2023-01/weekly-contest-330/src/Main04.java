import java.util.Arrays;
import java.util.Random;

/**
 * @author yangxiaozhuo
 * @date 2023/01/29
 */
public class Main04 {
    public static void main(String[] args) {
        Random random = new Random();
        Solution solution = new Solution();
        int n = 30;
        int[] nums = new int[]{1,2,5,3,6,4,7,9,8};
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = i + 1;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            swap(random.nextInt(n), random.nextInt(n),nums);
//        }
        System.out.println(solution.countQuadruplets1(nums));
        System.out.println(solution.countQuadruplets(nums));
    }

    private static void swap(int a, int b, int[] nums) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    static class Solution {
        public long countQuadruplets(int[] nums) {
            long res = 0;
            long[] rightBig = new long[nums.length];
            long[] leftSmall = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        rightBig[i]++;
                        leftSmall[i]++;
                    }
                }
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) {
                        res = res + rightBig[j] * leftSmall[i];
                    }
                }
            }
            return res;
        }
        public long countQuadruplets1(int[] nums) {
            long res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        for (int l = k + 1; l < nums.length; l++) {
                            if (nums[i] < nums[k] && nums[k] < nums[j] && nums[j] < nums[l]) {
                                res++;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
