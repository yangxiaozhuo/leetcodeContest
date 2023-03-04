package text03;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/02/19
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{8, 11, 17, 2, 25, 29, 21, 20, 4, 22};
        System.out.println(solution.squareFreeSubsets(nums));
    }
}

//[11,2,19,7,9,27]  15
//[8,11,17,2,25,29,21,20,4,22] 39
//[22,2,5,26,28,8,4,11,12,17,11,3,19,29,19,7,24,12,22,5,8,22] 1727
class Solution {
    long[] mi = new long[1010];
    int mod = 1000_000_007;
    HashSet<Integer> set = new HashSet<>();

    {
        mi[0] = 1;
        mi[1] = 2;
        set.add(4);
        set.add(8);
        set.add(9);
        set.add(12);
        set.add(16);
        set.add(18);
        set.add(20);
        set.add(24);
        set.add(25);
        set.add(27);
        set.add(28);
    }

    private long tow(int t) {
        if (mi[t] != 0) {
            return mi[t];
        }
        long temp = tow(t / 2);
        if (t % 2 == 0) {
            mi[t] = (temp * temp) % mod;
        } else {
            mi[t] = (temp * temp * 2) % mod;
        }
        return mi[t];
    }

    public int squareFreeSubsets(int[] nums) {
        Arrays.sort(nums);
        long res = 0;
        int[][] dp = new int[nums.length][20];
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                nums[i] = -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] != -1 && gcd(nums[i], nums[j]) == 1) {
                    temp++;
                }
            }
            res = (res + tow(temp)) % mod;
        }
        return (int) res;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}