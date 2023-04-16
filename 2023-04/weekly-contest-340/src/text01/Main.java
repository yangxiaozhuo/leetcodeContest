package text01;


import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/04/09
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{5, 1, 1, 2, 0, 0};
    }
}
class Solution {
    public int diagonalPrime(int[][] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (iszhi(nums[i][i])) {
                res = Math.max(res, nums[i][i]);
            }
            if(iszhi(nums[i][nums.length - i - 1])) {
                res = Math.max(res, nums[i][nums.length - i - 1]);
            }
        }
        return res;
    }

    private boolean iszhi(int n) {
        if(n < 2) {
            return false;
        }
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}