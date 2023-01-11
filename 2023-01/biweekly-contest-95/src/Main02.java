/**
 * @author yangxiaozhuo
 * @date 2023/01/07
 */
public class Main02 {
    static class DataStream {
        int[] nums = new int[100100];
        int index = 0;
        int value = 0;
        int k = 0;
        int t = 0;
        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
        }

        public boolean consec(int num) {
            nums[index++] = num;
            if (num == value) {
                t++;
            } else {
                t = 0;
            }
            return t >= k;
        }
    }
}
