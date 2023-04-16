package text03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxiaozhuo
 * @date 2023/04/01
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints1 = new int[]{1,4,1,3};
        int[] ints2 = new int[]{4, 7, 15, 8, 3, 5};
        System.out.println(solution.makeSubKSumEqual(ints1, 2));
    }
}

class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        long res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int t = i;
            while (arr[t] != -1) {
                list.add(arr[t]);
                arr[t] = -1;
                t += k;
                t = t % arr.length;
            }
            res += fun(list);
            list = new ArrayList<>();
        }
        return res;
    }

    private long fun(ArrayList<Integer> list) {
        int l = 1;
        int r = 1000000000;
        while (l < r) {
            int mid = l + r >> 1;
            if(check(list,mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        long sum = 0;
        for (int num : list) {
            sum = sum + Math.abs(num - l);
        }
        return sum;
    }

    private boolean check(ArrayList<Integer> list, int mid) {
        int sum1 = 0;
        int sum2 = 0;
        for (int num : list) {
            sum1 = sum1 + Math.abs(num - mid);
            sum2 = sum2 + Math.abs(num - mid - 1);
        }
        return sum2 > sum1;
    }
}