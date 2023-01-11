package one;

import java.util.Arrays;

/**
 * 1806. 还原排列的最少操作步数
 *
 * @author yangxiaozhuo
 * @date 2023/01/10
 */
public class Main09 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reinitializePermutation(8));
    }
    static class Solution {
        public int reinitializePermutation(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            for (int j = 0; j < 10; j++) {
                int[] ints = Arrays.copyOf(arr, arr.length);
                for (int i = 0; i < arr.length; i++) {
                    ints[i] = fun(arr,i);
                }
                arr = ints;
                System.out.println(Arrays.toString(arr));
            }
            return 0;
        }

        private int fun(int[] arr, int i) {
//            如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
//            如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
            if (i % 2 == 0) {
                return arr[i / 2];
            } else {
                return arr[arr.length / 2 + (i - 1) / 2];
            }
        }
    }
}
