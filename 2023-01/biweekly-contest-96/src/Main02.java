/**
 * @author yangxiaozhuo
 * @date 2023/01/21
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        [10,5,15,20]
//[20,10,15,5]
//        0
        int[] ints = new int[]{10,5,15,20};
        int[] ints1 = new int[]{20,10,15,5};
        System.out.println(solution.minOperations(ints1, ints, 0));
    }
    static class Solution {
        public long minOperations(int[] nums1, int[] nums2, int k) {
            long sum = 0;
            long res = 0;
            for (int i = 0; i < nums1.length; i++) {
                sum += nums1[i];
            }
            for (int i = 0; i < nums2.length; i++) {
                sum -= nums2[i];
            }
            if (sum != 0) {
                return -1;
            }
            int[] div = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                div[i] = nums1[i] - nums2[i];
                if(k == 0) {
                    if (div[i] != 0) {
                        return -1;
                    }
                } else {
                    if (div[i] % k != 0) {
                        return -1;
                    }
                }
            }
            for (int i = 0; i < div.length; i++) {
                if (div[i] > 0) {
                    res = res + (div[i] / k);
                }
            }
            return res;
        }
    }
}
