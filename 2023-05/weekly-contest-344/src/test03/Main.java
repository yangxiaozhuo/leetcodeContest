package test03;

/**
 * @author yangxiaozhuo
 * @date 2023/05/07
 */
public class Main {
}

class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int[] nums = new int[n];
        int temp = 0;
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int color = queries[i][1];
            if (index > 0 && nums[index] == nums[index - 1]) {
                if (nums[index] != 0) {
                    temp--;
                }
            }
            if (index < n - 1 && nums[index] == nums[index + 1]) {
                if (nums[index] != 0) {
                    temp--;
                }
            }
            nums[index] = color;
            if (index > 0 &&nums[index] == nums[index - 1]) {
                temp++;
            }
            if (index < n - 1 &&nums[index] == nums[index + 1]) {
                temp++;
            }
            res[i] = temp;
        }
        return res;
    }
}