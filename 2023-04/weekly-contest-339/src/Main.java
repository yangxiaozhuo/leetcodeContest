import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/04/03
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int res = 0;
            int n = Integer.parseInt(in.readLine());
            String s = in.readLine();
            int[] nums = new int[130];
            for (char c : s.toCharArray()) {
                nums[c]++;
                if (nums[c] == 1) {
                    res++;
                }
            }
            int[] pre = new int[130];
            int temp = res;
            for (char t : s.toCharArray()) {
                nums[t]--;
                pre[t]++;
                if (nums[t] == 0) {
                    temp--;
                }
                if (pre[t] == 1) {
                    temp++;
                }
                res = Math.max(res, temp);
            }
            System.out.println(res);
        }
    }
}
