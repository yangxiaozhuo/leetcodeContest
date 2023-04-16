package text03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/04/16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints1 = new int[]{1, 4, 1, 3};
        int[] ints2 = new int[]{4, 7, 15, 8, 3, 5};
    }
}

class Solution {
    public int addMinimum(String word) {
        int res = 0;
        int at = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; ) {
            if (chars[i] == at + 'a') {
                at++;
                i++;
                at = at % 3;
            } else {
                at++;
                res++;
                at = at % 3;
            }
        }
        if (at != 0) {
            res = res + 3 - at;
        }
        return res;
    }
}