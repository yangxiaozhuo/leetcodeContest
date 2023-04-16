package text01;


import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/04/02
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{5, 1, 1, 2, 0, 0};
        System.out.println(solution.findTheLongestBalancedSubstring("1"));
        System.out.println(solution.findTheLongestBalancedSubstring("001"));
        System.out.println(solution.findTheLongestBalancedSubstring("001100011110101"));
        System.out.println(solution.findTheLongestBalancedSubstring("0"));
    }
}
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            while (r < s.length() && s.charAt(r) == '0') {
                r++;
            }
            int ling = r - l;
            l = r;

            while (r < s.length() && s.charAt(r) == '1') {
                r++;
            }
            if (r - l >= ling) {
                res = Math.max(res, 2 * ling);
            } else {
                res = Math.max(res, 2 * (r - l));
            }
            l = r;
        }
        return res;
    }
}