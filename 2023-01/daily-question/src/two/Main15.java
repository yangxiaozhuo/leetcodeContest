package two;

/**
 * 2293. 极大极小游戏
 *
 * @author yangxiaozhuo
 * @date 2023/01/19
 */
public class Main15 {
    class Solution {
        public int minMaxGame(int[] nums) {
            int max = nums.length;
            while(max > 1) {
                max /= 2;
                for(int i = 0; i < max; i++) {
                    if(i % 2 == 0) {
                        nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                    } else{
                        nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                    }
                }
            }
            return nums[0];
        }
    }
}
