package three;

/**
 * 1742. 盒子中小球的最大数量
 * @author yangxiaozhuo
 * @date 2022/11/23
 */
public class Main23 {
    class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            int[] nums = new int[50];
            int res=  0;
            for(int i = lowLimit; i <= highLimit; i++) {
                nums[fun(i)]++;
            }
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(nums[i], res);
            }
            return res;
        }

        private int fun(int a) {
            int res = 0;
            while (a != 0) {
                res = res + a % 10;
                a = a / 10;
            }
            return res;
        }
    }
}
