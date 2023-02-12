package text02;

import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[]{"aba","bcb","ece","aa","e"};
        int[][] ints = new int[][]{{0,2},{1,4},{1,1}};
        System.out.println(Arrays.toString(solution.vowelStrings(strings, ints)));
    }
}

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (check(words[i])) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            res[i] = preSum[b + 1] - preSum[a];
        }
        return res;
    }

    private boolean check(String word) {
        char c = word.charAt(0);
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
            return false;
        }
        c = word.charAt(word.length() - 1);
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
            return false;
        }
        return true;
    }
}