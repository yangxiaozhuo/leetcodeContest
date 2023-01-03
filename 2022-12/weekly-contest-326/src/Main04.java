import java.util.ArrayList;

/**
 * @author yangxiaozhuo
 * @date 2023/01/01
 */
public class Main04 {
    class Solution {
        private boolean fun(int num) {
            if (num == 1) {
                return false;
            }
            for (int i = 2; i < num; i++) {
                if(num % i == 0) {
                    return false;
                }
            }
            return true;
        }
        public int[] closestPrimes(int left, int right) {
            ArrayList<Integer> list = new ArrayList<>();
            int[] res = new int[]{-1, -1};
            int min = Integer.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                if (fun(i)) {
                    list.add(i);
                }
                if(list.size() >= 2) {
                    int size = list.size();
                    if (list.get(size - 1) - list.get(size - 2) < min) {
                        min = list.get(size - 1) - list.get(size - 2);
                        res = new int[]{list.get(size - 2), list.get(size - 1)};
                    }
                    if (min <= 2) {
                        return res;
                    }
                }
            }
            return res;
        }

    }
}
