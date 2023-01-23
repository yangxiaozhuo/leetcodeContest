package acwing.Week3Day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/01/12
 */
public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s = in.readLine().split(" ");
        int[] nums = new int[n];
        int[] res = new int[n];
        int sum = 1;
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
            sum = sum * nums[i];
        }
        sum = sum / nums[nums.length - 1];
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] = m / sum;
            m = m % sum;
            if(i > 0) {
                sum = sum / nums[i - 1];
            }
            else {
                sum = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            sb.append(res[i]);
            if(i != nums.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}