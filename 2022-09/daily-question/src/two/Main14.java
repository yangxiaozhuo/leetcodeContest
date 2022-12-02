package two;

import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值
 *
 * @author yangxiaozhuo
 * @date 2022/09/14
 */
public class Main14 {
    class Solution {
        public double trimMean(int[] arr) {
            double ans =0;
            Arrays.sort(arr);
            for(int i=arr.length/20;i<arr.length*19/20;i++){
                ans+=arr[i];

            }
            return ans/(arr.length*9/10);
        }
    }
}
