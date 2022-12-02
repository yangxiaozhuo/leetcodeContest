package one;

import java.util.Arrays;

/**
 * 1769. 移动所有球到每个盒子所需的最小操作数
 *
 * @author yangxiaozhuo
 * @date 2022/12/02
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.minOperations("001011")));
    }
    static class Solution {
        public int[] minOperations(String boxes) {
            char[] chars = boxes.toCharArray();
            int[] res = new int[chars.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == '1') {
                        res[i] = res[i] + Math.abs(i - j);
                    }
                }
            }
            return res;
        }
    }
    static class Solution2 {
        public int[] minOperations(String boxes) {
            char[] chars = boxes.toCharArray();
            int[] front = new int[boxes.length()];
            int[] behind = new int[boxes.length()];
            int[] front1 = new int[boxes.length()];
            int[] behind1 = new int[boxes.length()];
            int temp = 0;
            for (int i = 0; i < chars.length; i++) {
                front[i] = temp;
                if (chars[i] == '1') {
                    temp = temp + i;
                }
            }
            temp = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                behind[i] = temp;
                if (chars[i] == '1') {
                    temp = temp + i;
                }
            }
            for (int i = 1; i < front1.length; i++) {
                front1[i] = front1[i - 1] + chars[i - 1] - '0';
            }
            for (int i = behind1.length - 2; i >= 0; i--) {
                behind1[i] = behind1[i + 1] + chars[i + 1] - '0';
            }
            int[] res = new int[chars.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = behind[i] - behind1[i] * i + front1[i] * i - front[i];
            }
            return res;
        }
    }
}
