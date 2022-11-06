package two;

/**
 * 769. 最多能完成排序的块
 *
 * @author yangxiaozhuo
 * @date 2022/10/13
 */
public class Main13 {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int[] minOfItAndRight = new int[arr.length];
            int min = arr[arr.length - 1];
            for (int i = arr.length - 1; i >= 0; i--) {
                min = Math.min(min, arr[i]);
                minOfItAndRight[i] = min;
            }
            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                if (minOfItAndRight[i] == i) {
                    res++;
                }
            }
            return res;
        }
    }
}
