package text04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        "eeecaeecdeeadcdbcaa"
//        "edecabe"  2
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 99999; i++) {
            stringBuilder.append("b");
        }
        System.out.println(solution.minimumScore(stringBuilder.toString() + "b", stringBuilder.toString() + 'z'));
    }
}

class Solution {
    public int minimumScore(String s, String t) {
        int l = 0;
        int r = t.length();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid, sChar, tChar)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, char[] sChar, char[] tChar) {
        int tlength = tChar.length;
        int slength = sChar.length;
        if (mid == tlength) {
            return true;
        }
        for (int i = 0; i <= tlength - mid; i++) {
            //从i到i + mid - 1都删了
            int index = 0;
            boolean flag = true;
            for (int j = 0; j < tlength; j++) {
                if (j >= i & j <= i + mid - 1) {
                    j = i + mid - 1;
                    continue;
                }
                while (index < slength && sChar[index] != tChar[j]) {
                    index++;
                }
                if (index == slength) {
                    flag = false;
                    break;
                }
                index++;
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}