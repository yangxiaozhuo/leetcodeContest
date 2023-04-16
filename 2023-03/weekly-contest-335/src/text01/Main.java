package text01;


import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{5, 1, 1, 2, 0, 0};
    }
}

class Solution {
    public int passThePillow(int n, int time) {
        int at = 1;
        int add = 1;
        while (time-- > 0) {
            if (at == n) {
                add = -1;
            }
            if (at == 1) {
                add =1;
            }
            at = at + add;
        }
        return at;
    }
}