/**
 * @author yangxiaozhuo
 * @date 2022/11/26
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bestClosingTime("YN"));
    }

    static class Solution {
        public int bestClosingTime(String customers) {
            int res = customers.length();
            int cost = 0;
            for (int i = 0; i < customers.length(); i++) {
                if (customers.charAt(i) == 'N') {
                    cost++;
                }
            }
            int min = cost;
            for (int i = res - 1; i >= 0; i--) {
                if (customers.charAt(i) == 'Y') {
                    cost++;
                } else {
                    cost--;
                }
                if (cost <= min) {
                    res = i;
                    min = cost;
                }
            }
            return res;
        }
    }
}
