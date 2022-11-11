/**
 * 2413. 最小偶倍数
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main01 {
    class Solution {
        public int smallestEvenMultiple(int n) {
            if(n%2==0) {
                return n;
            }
            return 2*n;
        }
    }
}
