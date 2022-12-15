package one;

import javax.swing.plaf.multi.MultiInternalFrameUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 1774. 最接近目标价格的甜点成本
 *
 * @author yangxiaozhuo
 * @date 2022/12/04
 */
public class Main04 {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 10};
        int[] ints2 = new int[]{2, 5};
        Solution solution = new Solution();
        System.out.println(solution.closestCost(ints, ints2, 9));
    }

    static class Solution {
        int res = 0;

        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            res = baseCosts[0];
            Arrays.sort(toppingCosts);
            for (int i = 0; i < baseCosts.length; i++) {
                dfs(toppingCosts, 0,baseCosts[i], target);
            }
            return res;
        }

        private void dfs(int[] toppingCosts, int index, int cost, int target) {
            if (Math.abs(res - target) < cost - target) {
                return;
            }
            if (Math.abs(res - target) > Math.abs(cost - target)) {
                res = cost;
            } else if(Math.abs(res - target) == Math.abs(cost - target)){
                res = Math.min(res, cost);
            }
            if (index == toppingCosts.length) {
                return;
            }
            dfs(toppingCosts, index + 1, cost,target);
            dfs(toppingCosts, index + 1, cost + toppingCosts[index],target);
            dfs(toppingCosts, index + 1, cost + toppingCosts[index] * 2,target);
        }
    }
}
