package three;

/**
 * 1652. 拆炸弹
 *
 * @author yangxiaozhuo
 * @date 2022/09/24
 */
public class Main24 {
    class Solution {
        public int[] decrypt(int[] code, int k) {
            if(k==0) return new int[code.length];
            int[] res =new int[code.length];
            int length = code.length;
            int sum = 0;
            if(k > 0) {
                for(int i = 1; i < k; i++) {
                    sum = sum + code[i];
                }
                for(int i = 0; i < length; i++) {
                    sum += code[(i + k) % length];
                    res[i % length] = sum;
                    sum -= code[(i + 1) % length];
                }
            } else {
                k = -k;
                for(int i = 0; i < k; i++) {
                    sum = sum + code[i];
                }
                for(int i = 0; i < length; i++) {
                    res[(i + k) % length] = sum;
                    sum -= code[i % length];
                    sum += code[(i + k) % length];
                }
            }

            return res;
        }
    }
}
