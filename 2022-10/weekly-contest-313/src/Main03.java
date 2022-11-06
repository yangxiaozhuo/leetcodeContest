/**
 * 2429. 最小 XOR
 *
 * @author yangxiaozhuo
 * @date 2022/10/02
 * 给你两个正整数 num1 和 num2 ，找出满足下述条件的整数 x ：
 * x 的置位数和 num2 相同，且
 * x XOR num1 的值 最小
 * 注意 XOR 是按位异或运算。
 * 返回整数 x 。题目保证，对于生成的测试用例， x 是 唯一确定 的。
 * 整数的 置位数 是其二进制表示中 1 的数目。
 * <p>
 * 示例 1：
 * 输入：num1 = 3, num2 = 5
 * 输出：3
 * 解释：
 * num1 和 num2 的二进制表示分别是 0011 和 0101 。
 * 整数 3 的置位数与 num2 相同，且 3 XOR 3 = 0 是最小的。
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizeXor(3, 5));
    }

    static class Solution {
        public int minimizeXor(int num1, int num2) {
            int oneOfNum1 = find(num1);
            int oneOfNum2 = find(num2);
            if (oneOfNum1 == oneOfNum2) {
                return num1;
            }
            if (oneOfNum1 > oneOfNum2) {
                int t = 0;
                int nums = num1;
                int temp = 0;
                while (t < oneOfNum1 - oneOfNum2) {
                    t = t + (nums & 1);
                    nums = nums >> 1;
                    temp++;
                }
                while ((nums & 1) == 0) {
                    nums = nums >> 1;
                    temp++;
                }
                return ((nums << (temp)) ^ num1) ^ num1;
            }
            int res = num1;
            int t = 0;
            int index = 0;
            while (index < oneOfNum2 - oneOfNum1) {
                if (((num1 >> t) & 1) == 0) {
                    res = res + (1 << t);
                    index++;
                }
                t++;
            }
            return res;
        }

        public int find(int nums) {
            int res = 0;
            while (nums > 0) {
                res = res + (nums & 1);
                nums = nums >> 1;
            }
            return res;
        }
    }
}
