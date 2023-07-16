package test01;

/**
 * @author yangxiaozhuo
 * @date 2023/07/08
 */
public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            if (b - a != 1) {
                continue;
            }
            int temp = 2;
            for (int j = i + 2; j < nums.length; j++) {
                int t = j - i;
                if (t % 2 == 0 && nums[j] == a) {
                    temp++;
                } else if (nums[j] == b && t % 2 == 1){
                    temp++;
                } else {
                    break;
                }
            }
            res = Math.max(temp, res);
        }
        return res;
    }
}