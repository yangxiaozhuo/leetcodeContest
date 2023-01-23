/**
 * @author yangxiaozhuo
 * @date 2023/01/01
 */
public class Main01 {
    class Solution {
        public int countDigits(int num) {
            int res = 0;
            int temp = num;
            while(temp != 0) {
                if(num % (temp % 10) ==0 ) {
                    res++;
                }
                temp /= 10;
            }
            return res;
        }
    }
}
