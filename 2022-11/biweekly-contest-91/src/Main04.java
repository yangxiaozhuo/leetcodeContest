import java.util.Arrays;

/**
 * 6239. 根据限制分割消息
 * @author yangxiaozhuo
 * @date 2022/11/12
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "this is really a very awesome message";
        System.out.println(Arrays.toString(solution.splitMessage(s, 9)));
    }
    static class Solution {
        public String[] splitMessage(String message, int limit) {
            int len = message.length();
            int l = 1;
            int r = message.length();
            while(l < r) {
                int mid = l + r >> 1;
                if(fun(len,limit,mid) > mid) {
                    l = mid + 1;
                } else if(fun(len,limit,mid) == mid) {
                    l = mid;
                    break;
                } else {
                    r = mid - 1;
                }
            }
            String[] res = new String[l];
            int start = 0;
            for (int i = 1; i <= l; i++) {
                Object[] temp = build(i, l, message, limit, start);
                res[i-1] = (String) temp[0];
                start = (int)temp[1];
            }
            return res;
        }

        private Object[] build(int i, int l, String message, int limit,int start) {
            String res = "<" + i + "/" + l + ">";
            int temp = Math.min(start + limit - res.length(),message.length());
            res = message.substring(start, temp) + res;
            return new Object[]{res, temp};
        }

        private int fun(int len, int limit, int mid) {
            String a = mid + "";
            int sum = len + mid * (a.length() + 3);
            sum = sum + allLong(mid);
            return sum / limit + Math.min(1, sum % limit);
        }
        //计算从1 到 mid 有多长
        private int allLong(int mid) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i <= mid; i++) {
                stringBuilder.append(i);
            }
            return stringBuilder.length();
        }
    }
}
