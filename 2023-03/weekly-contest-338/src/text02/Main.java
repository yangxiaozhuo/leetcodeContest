package text02;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,2};  //[998,2]  true
        System.out.println(solution.primeSubOperation(nums));
    }
}

class Solution {
    static int N = 30000;
    static boolean[] st = new boolean[N];
    static int index = 0;
    static int[] primes = new int[N];

    static {
        st[0] = true;
        st[1] = true;
        for (int i = 2; i < N - 5; i++) {
            if (!st[i]) {
                primes[index++] = i;
            }
            for (int j = 0; primes[j] <= (N - 5) / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            int t = nums[i] - nums[i + 1];
            if (t >= 0) {
                nums[i] = nums[i] - find(t);
                if (nums[i] <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int t) {
        int l = 0;
        int r = index - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (primes[mid] > t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return primes[l];
    }
}