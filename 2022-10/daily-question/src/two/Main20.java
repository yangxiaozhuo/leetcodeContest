package two;

/**
 * 779. 第K个语法符号
 *
 * @author yangxiaozhuo
 * @date 2022/10/20
 */
public class Main20 {
    class Solution {
        public int kthGrammar(int N, int K) {
            if (N == 1 && K == 1)
                return 0;
            int a = kthGrammar(N - 1, (K + 1) / 2);  //求父结点的值；(K+1)/2为父结点的序号
            int b = -(a - 1);   //若a=0则b=1,若a=1则b=0
            if (K % 2 == 1)
                return a;   //K为奇数则其值与父结点相同
            else
                return b;
        }
    }
}
