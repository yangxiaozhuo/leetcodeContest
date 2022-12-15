package one;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 * @author yangxiaozhuo
 * @date 2022/12/10
 */
public class Main09 {
    class Solution {
        public boolean checkPowersOfThree(int n) {
            while(n > 0) {
                if(n%3==2) {
                    return false;
                } else {
                    n = n / 3;
                }
            }
            return true;
        }
    }
}
