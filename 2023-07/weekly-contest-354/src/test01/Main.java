package test01;

/**
 * @author yangxiaozhuo
 * @date 2023/07/16
 */
public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int sumOfSquares(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length %(i+1) == 0) {
                res = res + nums[i] * nums[i];
            }
        }
        return res;
    }
}
