package text02;

/**
 * @author yangxiaozhuo
 * @date 2023/04/16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 1, 1, 2};  //[998,2]  true
    }
}

class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int res = 0;
        int maxid = 0;
        for (int i = 0; i < divisors.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    sum++;
                }
            }
            if (sum > res) {
                res = sum;
                maxid = i;
            } else if (sum == res && divisors[i] < divisors[maxid]) {
                maxid = i;
            }
        }
        return divisors[maxid];
    }
}