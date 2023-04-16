package test01;

/**
 * @author yangxiaozhuo
 * @date 2023/03/20
 */
public class Main20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDupDigitsAtMostN(100));
    }
    static class Solution {
        public int numDupDigitsAtMostN(int n) {
            String s = n + "";
            int len = s.length();
            int t = len - 1;
            int sum = 0;
            if(t != 0) {
                sum = 9;
                for(int i = 1; i < t; i++) {
                    sum = sum * (10 - i);
                }
            }
            if (t - 1 > 0) {
                int temp = 1;
                for(int i = 0; i < t - 1; i++) {
                    temp *= 10;
                }
                sum += temp - 1;
            }
            for(int i = 0; i < len; i++) {
                t = s.charAt(i) - '0';
                sum = sum + fun(t, len - i - 1);
            }
            return n - sum;
        }
        public int fun(int first, int len) {
            if (first == 0) {
                return 1;
            }
            first = first - 1;
            for(int i = 0; i < len; i++) {
                first = first * (9 - i);
            }
            return first;
        }
    }
}
