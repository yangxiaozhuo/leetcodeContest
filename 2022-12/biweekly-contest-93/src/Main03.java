/**
 * @author yangxiaozhuo
 * @date 2022/12/10
 */
public class Main03 {
    class Solution {
        public int maxJump(int[] stones) {
            int len = stones.length;
            int res = stones[len - 1] - stones[len - 2];
            for (int i = len - 3; i >= 0; i--) {
                int a = stones[i];
                int b = stones[i + 2] - a;
                res = Math.max(b, res);
            }
            return res;
        }
    }
}
