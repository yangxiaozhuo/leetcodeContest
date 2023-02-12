package text01;

import sun.font.FontRunIterator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{5, 1, 1, 2, 0, 0};
    }
}

class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int num : nums) {
            sb.append(num);
        }
        int[] res = new int[sb.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = sb.charAt(i) - '0';
        }
        return res;
    }
}