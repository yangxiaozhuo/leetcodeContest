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
        System.out.println(solution.splitNum(4325));
        System.out.println(solution.splitNum(687));
    }
}

class Solution {
    public int splitNum(int num) {
        String s = num + "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int res = 0;
        int len = chars.length / 2;
        int num1 = 0;
        int num2 = 0;
        int index = 0;
        while (index < chars.length) {
            if (index % 2 == 0) {
                num1 *= 10;
                num1 = num1 + chars[index] - '0';
            } else {
                num2 *= 10;
                num2 = num2 + chars[index] - '0';
            }
            index++;
        }
        return num1 + num2;
    }
}