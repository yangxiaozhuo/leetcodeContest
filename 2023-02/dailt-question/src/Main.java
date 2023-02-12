import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yangxiaozhuo
 * @date 2023/02/12
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Hashtable<Integer, Integer> table = new Hashtable<>();
        table.put(1,1);
        table.get(1);
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(2,2);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] s = in.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            System.out.println(fun(nums));
        }
    }

    private static String fun(int[] nums) {
        int l = 0;
        int r = 0;
        int min = 0;
        int max = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (zhuanzhe(i,nums)) {
                max = nums[i];
                min = nums[i];
                l = i - 1;
                for (int j = i+1; j < nums.length - 1; j++) {
                    if (zhuanzhe(j,nums)) {
                        r = j + 1;
                        min = Math.min(min, nums[j]);
                        max = Math.max(max, nums[j]);
                        if (nums[l] < max && nums[l] > min && nums[r] < max && nums[r] > min) {
                            return (l + 1) + " " + (r + 1);
                        }
                    }
                }
            }
        }
        return "-1";
    }

    private static boolean zhuanzhe(int i, int[] nums) {
        return  (nums[i - 1] - nums[i]) * (nums[i] - nums[i + 1]) < 0;
    }
}
