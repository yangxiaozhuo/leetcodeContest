package two;

/**
 * 1608. 特殊数组的特征值
 *
 * @author yangxiaozhuo
 * @date 2022/09/12
 */
public class Main12 {
    class Solution {
        public int specialArray(int[] nums) {
            int[] arr = new int[1001];
            for(int i = 0; i < nums.length; i++) {
                arr[nums[i]]++;
            }
            for(int i = 999; i >= 502; i--) {
                arr[i] = arr[i] + arr[i + 1];
            }
            for(int i = 501; i >= 0; i--) {
                arr[i] = arr[i] + arr[i + 1];
                if(arr[i]==i) return i;
            }
            return -1;
        }
    }
}
