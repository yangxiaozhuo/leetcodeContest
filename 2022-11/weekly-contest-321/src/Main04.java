import java.util.HashMap;
import java.util.Map;

/**
 * 2488. 统计中位数为 K 的子数组
 *
 * @author yangxiaozhuo
 * @date 2022/11/27
 */
public class Main04 {
    public static void main(String[] args) {
        int[] ints = new int[]{5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14};  //6 -13
//        int[] ints = new int[]{6,2,8,7,12,4,11,5,9,1,10,3};// 5 -16
        Solution solution = new Solution();
        System.out.println(solution.countSubarrays(ints, 6));  //13
    }

    static class Solution {
        public int countSubarrays(int[] nums, int k) {
            int[] arr = new int[nums.length];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == k) {
                    index = i;
                    break;
                }
            }
            int t = 0;
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] > k) {
                    t++;
                } else {
                    t--;
                }
                arr[i] = t;
            }
            t = 0;
            for (int i = index - 1; i >= 0; i--) {
                if (nums[i] > k) {
                    t++;
                } else {
                    t--;
                }
                arr[i] = t;
            }
            HashMap<Integer, Integer> left = new HashMap<>();
            for (int i = 0; i < index; i++) {
                left.put(arr[i], left.getOrDefault(arr[i], 0) + 1);
            }
            HashMap<Integer, Integer> right = new HashMap<>();
            for (int i = index + 1; i < arr.length; i++) {
                right.put(arr[i], right.getOrDefault(arr[i], 0) + 1);
            }
            int res = 0;
            for (Map.Entry<Integer, Integer> entry : right.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (key > 1) {
                    res = res + left.getOrDefault(-key, 0) * value;
                    res = res + left.getOrDefault(-key + 1, 0) * value;
                } else if (key == 1) {
                    res = res + left.getOrDefault(-1, 0) * value;
                    res = res + left.getOrDefault(0, 0) * value;
                    res = res + value;
                } else if (key == 0) {
                    res = res + left.getOrDefault(0, 0) * value;
                    res = res + left.getOrDefault(1, 0) * value;
                    res = res + value;
                } else {
                    res = res + left.getOrDefault(-key, 0) * value;
                    res = res + left.getOrDefault(-key + 1, 0) * value;
                }
            }
            res = res + left.getOrDefault(1, 0);
            res = res + left.getOrDefault(0, 0);
            return res + 1;
        }
    }
}
