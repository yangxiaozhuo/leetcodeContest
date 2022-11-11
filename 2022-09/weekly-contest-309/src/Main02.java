import java.util.HashMap;

/**
 * 2400. 恰好移动 k 步到达某一位置的方法数目
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main02 {
    class Solution {
        HashMap<String, Integer> map = new HashMap<>();
        int MOD = (int) Math.pow(10, 9) + 7;

        public int numberOfWays(int startPos, int endPos, int k) {
            if (Math.abs(endPos - startPos) % 2 != k % 2) return 0;
            if (Math.abs(startPos - endPos) > k) return 0;
            return fun(startPos, endPos, k);
        }

        public int fun(int x, int endPos, int k) {
            if (map.containsKey(x + "," + k)) return map.get(x + "," + k);
            if (Math.abs(x - endPos) > k) {
                map.put(x + "," + k, 0);
                return 0;
            }
            if (k == 0) {
                map.put(x + "," + k, 1);
                return 1;
            }
            int temp = (fun(x - 1, endPos, k - 1) + fun(x + 1, endPos, k - 1)) % MOD;
            map.put(x + "," + k, temp);
            return temp;
        }
    }
}
