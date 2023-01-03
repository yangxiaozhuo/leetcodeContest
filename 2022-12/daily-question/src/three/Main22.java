package three;

import java.util.HashSet;

/**
 * 1799. N 次操作后的最大分数和
 *
 * @author yangxiaozhuo
 * @date 2022/12/22
 */
public class Main22 {
    public static void main(String[] args) {
        int[] ints = new int[]{39759,619273,859218,228161,944571,597983,483239,179849,868130,909935,912143,817908};
        Solution solution = new Solution();
        System.out.println(solution.maxScore(ints));
    }

    static class Solution {
        public int maxScore(int[] nums) {
            int[][] gcdTemp = new int[nums.length][nums.length];
            for (int i = 0; i < gcdTemp.length; i++) {
                for (int j = 0; j < gcdTemp.length; j++) {
                    if (i == j) {
                        gcdTemp[i][j] = 0;
                    } else {
                        gcdTemp[i][j] = gcd(nums[i], nums[j]);
                    }
                }
            }
            int res = 0;
            int n = nums.length / 2;
            HashSet<Integer> set = new HashSet<>();
            while (n > 0) {
                int a = 0;
                int b = 0;
                int max = 0;
                for (int i = 0; i < gcdTemp.length; i++) {
                    for (int j = 0; j < gcdTemp.length; j++) {
                        if (gcdTemp[i][j] >= max && !set.contains(i) && !set.contains(j)) {
                            max = gcdTemp[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
                set.add(a);
                set.add(b);
                res += n * max;
                n = n - 1;
            }
            return res;
        }

        public int gcd(int a, int b) {
            if (a % b == 0) {
                return b;
            } else {
                return gcd(b, a % b);
            }
        }
    }
}
