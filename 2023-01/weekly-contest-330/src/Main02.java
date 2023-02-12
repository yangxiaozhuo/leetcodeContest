/**
 * @author yangxiaozhuo
 * @date 2023/01/29
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(111);
    }

    static class Solution {
        public int monkeyMove(int n) {
            int mod = 1_000_000_007;
            long temp = fastmi(n, mod);
            return (int) (temp + mod - 2) % mod;
        }

        private long fastmi(int n, int mod) {
            if (n == 1) {
                return 2;
            } else if (n == 0) {
                return 1;
            }
            long temp = fastmi(n / 2,mod);
            if (n % 2 == 0) {
                return (temp * temp) % mod;
            } else {
                return (((temp * temp) % mod) * 2) % mod;
            }
        }
    }
}
