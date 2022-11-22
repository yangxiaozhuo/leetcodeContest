package three;

/**
 * 878. 第 N 个神奇数字
 *
 * @author yangxiaozhuo
 * @date 2022/11/22
 */
public class Main22 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthMagicalNumber(1000000000,40000,40000));
    }
    static class Solution {
        public int nthMagicalNumber(int n, int a, int b) {
            long mod = 1000000007;
            long l = 0;
            long r = (long)n * a;
            long gcd = gcd(a, b);
            gcd = a * b / gcd;
            while (l < r) {
                long mid = l + r >> 1;
                long t = mid / a + mid / b - mid / (gcd);
                if (t < n) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return (int) (r % mod);
        }

        private long gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}
