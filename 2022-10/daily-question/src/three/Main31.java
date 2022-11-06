package three;

/**
 * 81. 神奇字符串
 *
 * @author yangxiaozhuo
 * @date 2022/10/31
 */
public class Main31 {
    static class Solution {
        static int[] num = new int[100005];//StringBuilder s = new StringBuilder("122");
        static int[] sum = new int[100010];

        static {
            num[0] = 1;
            num[1] = 2;
            num[2] = 2;
            int max = 3;
            int index = 2;
            while (max < 100000) {
                int c = num[index];
                int c1 = num[max - 1];
                for (int i = 0; i < c; i++) {
                    num[max++] = c1 == 1 ? 2 : 1;// s.append(c1 == '1' ? '2' : '1');
                }
                index = index + 1;
            }

            for (int i = 0; i < num.length; i++) {
                if (num[i] == 1) {
                    sum[i + 1] = sum[i] + 1;
                } else {
                    sum[i + 1] = sum[i];
                }
            }
        }

        public int magicalString(int n) {
            return sum[n];
        }
    }
}
