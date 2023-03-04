package text04;

import sun.font.FontRunIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

/**
 * @author yangxiaozhuo
 * @date 2023/02/19
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{1, 15, 21}, {3, 0, 0}, {3, 0, 0}, {2, 21, 0}, {2, 13, 0}, {3, 0, 0}};
        int[] ints1 = new int[]{0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1};
        int[] ints2 = new int[]{30, 46, 43, 34, 39, 16, 14, 41, 22, 11, 32, 2, 44, 12, 22, 36, 44, 49, 50, 10, 33, 7, 42};
        System.out.println(Arrays.toString(solution.handleQuery(ints1, ints2, ints)));
    }
}
class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        long[] res = new long[1];
        return res;
    }

}