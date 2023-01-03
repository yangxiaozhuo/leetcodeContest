package two;

import java.util.ArrayList;
import java.util.List;

/**
 * 1703. 得到连续 K 个 1 的最少相邻交换次数
 * @author yangxiaozhuo
 * @date 2022/12/18
 */
public class Main18 {
    class Solution {
        public int minMoves(int[] nums, int k) {
            List<Integer> g = new ArrayList<Integer>();
            List<Integer> preSum = new ArrayList<Integer>();
            preSum.add(0);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    g.add(i - g.size());
                    preSum.add(preSum.get(preSum.size() - 1) + g.get(g.size() - 1));
                }
            }
            int m = g.size(), res = Integer.MAX_VALUE;
            for (int i = 0; i <= m - k; i++) {
                int mid = i + k / 2;
                int r = g.get(mid);
                res = Math.min(res, (1 - k % 2) * r + (preSum.get(i + k) - preSum.get(mid + 1)) - (preSum.get(mid) - preSum.get(i)));
            }
            return res;
        }
    }
}
