import java.util.ArrayList;

/**
 * 2411. 按位或最大的最小子数组长度
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main03 {
    class Solution {
        public int[] smallestSubarrays(int[] nums) {
            int[] res = new int[nums.length];
            ArrayList<int[]> arr = new ArrayList<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                int num = nums[i];
                arr.add(new int[]{0, i});
                int k = 0;
                for (int j = 0; j < arr.size(); j++) {
                    int[] ints = arr.get(j);
                    ints[0] |= num;
                    if (arr.get(k)[0] == ints[0]) {
                        arr.get(k)[1] = ints[1];
                    } else {
                        k++;
                        arr.set(k, arr.get(j));
                    }
                }
                while (arr.size() > k + 1) {
                    arr.remove(arr.size() - 1);
                }
                res[i] = arr.get(0)[1] - i + 1;
            }
            return res;
        }
    }
}
