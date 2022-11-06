package one;

/**
 * 927. 三等分
 *
 * @author yangxiaozhuo
 * @date 2022/10/06
 */
public class Main06 {
    class Solution {
        public int[] threeEqualParts(int[] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            if (sum % 3 != 0) {
                return new int[]{-1, -1};
            }
            if(sum == 0) {
                return new int[]{0, arr.length - 1};
            }
            sum = sum / 3;  // i是第一个的结尾  j是第三个的开头
            int t = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                t = t + arr[i];
                if (t == sum) {
                    t = i;
                    break;
                }
            }
            int[] target = new int[arr.length - t];
            for (int i = t; i < arr.length; i++) {
                target[i - t] = arr[i];
            }
            int j = 0;
            int i = 0;
            int[] res = new int[2];
            while (i < arr.length && arr[i] == 0) {
                i++;
            }
            for (; i < arr.length; i++) {
                if (arr[i] != target[j]) {
                    return  new int[]{-1, -1};
                } else {
                    j++;
                }
                if (j == target.length) {
                    res[0] = i;
                    i++;
                    break;
                }
            }
            j = 0;
            while (i < arr.length && arr[i] == 0) {
                i++;
            }
            for (; i < arr.length; i++) {
                if (arr[i] != target[j]) {
                    return  new int[]{-1, -1};
                } else {
                    j++;
                }
                if (j == target.length) {
                    res[1] = i + 1;
                    break;
                }
            }
            return res;
        }
    }
}
