package three;

/**
 * 面试题 17.09. 第 k 个数
 *
 * @author yangxiaozhuo
 * @date 2022/09/28
 */
public class Main28 {
    class Solution {
        public int getKthMagicNumber(int k) {
            int[] result = new int[k];
            result[0] = 1;
            int result3 = 0;
            int result5 = 0;
            int result7 = 0;
            for(int i = 1; i < k; i++) {
                int temp = min(result[result3] * 3, result[result5] * 5, result[result7] * 7);
                if(temp % 3 == 0) {
                    result3++;
                }
                if(temp % 5 == 0) {
                    result5++;
                }
                if(temp % 7 == 0) {
                    result7++;
                }
                result[i] = temp;
            }
            return result[k-1];
        }
        public int min(int a,int b, int c) {
            return Math.min(a,Math.min(b,c));
        }
    }
}
