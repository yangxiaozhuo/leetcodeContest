package test01;

/**
 * @author yangxiaozhuo
 * @date 2023/06/04
 */
public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int minimizedStringLength(String s) {
        int[] nums = new int[26];
        for(char c : s.toCharArray()) {
            nums[c - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res++;
            }
        }
        return res;
    }
}