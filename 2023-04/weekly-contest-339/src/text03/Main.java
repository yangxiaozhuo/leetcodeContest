package text03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxiaozhuo
 * @date 2023/04/02
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints1 = new int[]{1,4,1,3};
        int[] ints2 = new int[]{4, 7, 15, 8, 3, 5};
    }
}

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int[] nums = new int[reward1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < reward2.length; i++) {
            res += reward2[i];
        }
        for (int i = 0; i < k; i++) {
            res += nums[nums.length - i - 1];
        }
        return res;
    }
}