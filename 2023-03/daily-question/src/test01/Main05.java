package test01;

/**
 * 1599. 经营摩天轮的最大利润
 * https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/
 *
 * @author yangxiaozhuo
 * @date 2023/03/05
 */
public class Main05 {
    public static void main(String[] args) {
        int[] ints = new int[]{2};
        Solution solution = new Solution();
        System.out.println(solution.minOperationsMaxProfit(ints, 2, 4));
    }

    static class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            int res = 0;
            int resIndex = -1;
            int money = 0;
            int index = 0;
            int people = 0;
            int t = 0;
            lun lun = new lun();
            while (index < customers.length || people > 0) {
                if (index < customers.length) {
                    people += customers[index];
                    index++;
                }
                lun.remove();
                int temp = Math.min(4, people);
                lun.add(temp);
                people -= temp;
                money = money + temp * boardingCost - runningCost;
                t++;
                if (money > res) {
                    res = money ;
                    resIndex = t;
                }
            }
            if (money > res) {
                return t;
            }
            return resIndex;
        }

        class lun {
            int[] nums = new int[4];
            int p = 0;
            int l = 0;
//            int sum = 0;
            int ler = 0;

            public void add(int num) {
                nums[p] = num;
                p++;
                p = p % 4;
//                sum += num;
                if (num != 0) {
                    ler = 3;
                } else {
                    ler--;
                    ler = Math.max(ler, 0);
                }
            }

            public int remove() {
                int res = nums[l];
                l++;
                l = l % 4;
//                sum -= res;
                return res;
            }

//            public int sum() {
//                return sum;
//            }
        }
    }
}
