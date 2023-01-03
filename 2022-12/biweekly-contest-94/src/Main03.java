import java.util.Map;

/**
 * @author yangxiaozhuo
 * @date 2022/12/24
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizeSet(92761,
                48337,
                208563424,
                9115778));
    }

    static class Solution {
        public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
            long l = 1;
            long r = 1000000000;
            while (l < r) {
                long mid = l + r >> 1;
                if (fun(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return (int) l;
        }

        private boolean fun(long mid, int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
            if (mid < uniqueCnt1 + uniqueCnt2) {
                return false;
            }
            if (mid - mid / divisor1 < uniqueCnt1) {
                return false;
            }
            if (mid - mid / divisor2 < uniqueCnt2) {
                return false;
            }
            if (divisor1 == divisor2) {
                return mid - mid / divisor1 >= uniqueCnt1 + uniqueCnt2;
            }
            uniqueCnt1 = (int) Math.max(0,uniqueCnt1 - mid / divisor2  + mid / lcm(divisor1, divisor2));
            uniqueCnt2 = (int) Math.max(0,uniqueCnt2 - mid / divisor1  + mid / lcm(divisor1, divisor2));
            return uniqueCnt1 + uniqueCnt2 <= (mid - mid / lcm(divisor1,divisor2));
        }

        private long lcm(int divisor1, int divisor2) {
            return divisor1 * divisor2 / lab(divisor1, divisor2);
        }

        private int lab(int divisor1, int divisor2) {
            if (divisor1 % divisor2 == 0) {
                return divisor2;
            } else {
                return lab(divisor2, divisor1 % divisor2);
            }
        }
    }

    static class Solution2 {
        public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
            int res = 1;
            while (uniqueCnt1 > 0 && uniqueCnt2 > 0) {
                if (res % divisor1 != 0) {
                    uniqueCnt1--;
                } else if (res % divisor2 != 0) {
                    uniqueCnt2--;
                }
                res++;
            }
            while (uniqueCnt1 > 0) {
                if (res % divisor1 != 0) {
                    uniqueCnt1--;
                }
                res++;
            }
            while (uniqueCnt2 > 0) {
                if (res % divisor2 != 0) {
                    uniqueCnt2--;
                }
                res++;
            }
            return res - 1;
        }
    }
}
