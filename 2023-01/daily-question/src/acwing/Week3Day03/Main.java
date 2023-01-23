package acwing.Week3Day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/01/12
 */

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] nums = new int[n];
        String[] s = in.readLine().split(" ");
        double sum = 0;
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
            sum += nums[i];
        }
        double average = sum / n;
        double da = 0;
        for(int i = 0; i < n; i++) {
            da = da + (nums[i] - average) * (nums[i] - average);
        }
        da = da / n;
        da = find(da);
        for(int num : nums) {
            System.out.println((num - average) / da);
        }
    }
    public static double find(double da) {
        double l = 1;
        double r = 10000000;
        while(r - l > 0.0000001){
            double mid = (r + l) / 2;
            if(mid * mid > da) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }
}