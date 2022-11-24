import java.util.Arrays;

/**
 * 6234. 最小公倍数为 K 的子数组数目
 * 
 * @author yangxiaozhuo
 * @date 2022/11/13
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[1000];
        Arrays.fill(ints, 1000);
        long l = System.currentTimeMillis();
        System.out.println(solution.subarrayLCM(ints, 1000));
        long end = System.currentTimeMillis();
        System.out.println(end - l);
    }
    static class Solution {
        public int subarrayLCM(int[] nums, int k) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    int LCM = 1;
                    LCM = lcm(LCM, nums[j]);
                    if(LCM > k) {
                        break;
                    }
                    if(LCM == k) {
                        res++;
                    }
                }
            }
            return res;
        }

        private int lcm(int lcm, int num) {
            return lcm * num / bac(lcm, num);
        }

        private int bac(int lcm, int num) {
            return num == 0 ? lcm : bac(num, lcm % num);
        }
    }
     static class Solution2 {
        static int[][] dp = new int[1001][1001];
        public int subarrayLCM(int[] nums, int k) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > k) {
                        break;
                    }
                    if(check(nums, i, j, k)) {
                        res++;
                    }
                }
            }
            return res;
        }

        private boolean check(int[] nums, int start, int end, int k) {
            if (start == end) {
                return k == nums[start];
            }
            int res = 1;
            for (int i = start; i <= end; i++) {
                if (res % nums[i] == 0) {
                    return true;
                }
                int a = bac(nums[i],res);
                res = res * nums[i] / a;
                if (res > k) {
                    return false;
                }
            }
            return res == k;
        }

        private int bac(int a, int b) {
            if (dp[a][b] != 0) {
                return dp[a][b];
            } else if (dp[b][a] != 0) {
                return dp[b][a];
            }
            if (a % b == 0) {
                dp[a][b] = b;
                dp[b][a] = b;
                return b;
            } else {
                int t = bac(b, (a % b));
                dp[a][b] = t;
                dp[b][a] = t;
                return t;
            }
        }
    }
}
