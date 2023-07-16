package test2;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/05/13
 */
public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int matrixSum(int[][] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        for (int i = 0; i < nums[0].length; i++) {
            int temp = nums[0][i];
            for (int j = 0; j < nums.length; j++) {
                temp = Math.max(temp, nums[j][i]);
            }
            res += temp;
        }
        return res;
    }
}