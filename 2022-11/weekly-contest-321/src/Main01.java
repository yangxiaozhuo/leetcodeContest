/**
 * 2485. 找出中枢整数
 *
 * @author yangxiaozhuo
 * @date 2022/11/27
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotInteger(1));
    }
    static class Solution {
        public int pivotInteger(int n) {
            for (int i = 1; i < n; i++) {
                int a = (1 + i) * i / 2;
                int b = (i + n) * (n - i + 1) / 2;
                if (a == b) {
                    return i;
                }
            }
            return -1;
        }
    }
}
