package test01;

/**
 * 982. 按位与为零的三元组
 *
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main04 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int countTriplets(int[] nums) {
            int[] two = new int[2 << 16];
            for(int i = 0; i < nums.length; i++) {
                for(int num : nums) {
                    two[num & nums[i]]++;
                }
            }
            int res = 0;
            for(int i = 0; i < two.length; i++) {
                for(int temp : nums) {
                    if((i & temp) == 0) {
                        res += two[i];
                    }
                }
            }
            return res;
        }
    }
}
