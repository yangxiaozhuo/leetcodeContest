package acwing.Week4Day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.acwing.com/problem/content/3425/
 *
 * @author yangxiaozhuo
 * @date 2023/01/19
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] nums = new int[n + 1];
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 2; i <= n; i++) {
            nums[i] = Integer.parseInt(in.readLine());
            arr[nums[i]].add(i);
        }
        System.out.println(fun(1, arr, nums));
    }

    private static int fun(int at, ArrayList<Integer>[] arr, int[] nums) {
        if (arr[at].size() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < arr[at].size(); i++) {
            max = Math.max(max, fun(arr[at].get(i), arr, nums));
        }
        return arr[at].size() + max;
    }
}