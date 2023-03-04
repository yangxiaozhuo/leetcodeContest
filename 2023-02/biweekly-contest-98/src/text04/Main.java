package text04;

import sun.font.FontRunIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

/**
 * @author yangxiaozhuo
 * @date 2023/02/18
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

//[0,0,0,0,1,0,0,0,1,1,0,1,0,1,1,1,0,0,0,0,1,1,1]
//        [30,46,43,34,39,16,14,41,22,11,32,2,44,12,22,36,44,49,50,10,33,7,42]
//        [[1,15,21],[3,0,0],[3,0,0],[2,21,0],[2,13,0],[3,0,0]]
//        [679,679,1053]
class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        BitSet bitSet = new BitSet();
        ArrayList<Long> longs = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < nums2.length; i++) {
            sum += nums2[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums1[i] == 1) {
                bitSet.set(i, true);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 3) {
                longs.add(sum);
            } else if (queries[i][0] == 2) {
                if (queries[i][1] != 0) {
                    int allOne = 0;
                    for (int j = 0; j < bitSet.size(); j++) {
                        if (bitSet.get(j)) {
                            allOne++;
                        }
                    }
                    sum = sum + queries[i][1] * allOne;
                }
            } else {
                //[l,r]反转
                BitSet bitSet2 = new BitSet();
                bitSet2.set(queries[i][1], queries[i][2] + 1, true);
                bitSet.xor(bitSet2);
            }
        }
        long[] res = new long[longs.size()];
        for (int i = 0; i < longs.size(); i++) {
            res[i] = longs.get(i);
        }
        return res;
    }

    private long fun(int[] nums1, int[] div) {
        long res = 0;
        int t = 0;
        for (int i = 0; i < nums1.length; i++) {
            t += div[i];
            res = res + (((nums1[i] + t) % 2 == 0) ? 0 : 1);
        }
        return res;
    }
}