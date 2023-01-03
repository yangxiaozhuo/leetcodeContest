package two;

/**
 * 1785. 构成特定和需要添加的最少元素
 * @author yangxiaozhuo
 * @date 2022/12/16
 */
public class Main16 {
    class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            long sum = 0;
            for(int i : nums) {
                sum += i;
            }
            long div = Math.abs(goal - sum);
            return (int)((limit + div - 1 ) / limit);
        }
    }
}
