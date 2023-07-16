package test4;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/05/13
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int temp = 1000000000;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < 100000; i++) {
            sb.append(temp);
            temp--;
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
//        System.out.println(sb.toString());
        FileWriter fileWriter = new FileWriter("a.txt");
        fileWriter.write(sb.toString());
        fileWriter.flush();
//        System.out.println(solution.sumOfPower(new int[]{2, 1, 4}));
//        System.out.println(solution.sumOfPower(new int[]{658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108, 680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187, 906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206}));
//        [658,489,777,2418,1893,130,2448,178,1128,2149,1059,1495,1166,608,2006,713,1906,2108,680,1348,860,1620,146,2447,1895,1083,1465,2351,1359,1187,906,533,1943,1814,1808,2065,1744,254,1988,1889,1206]
//        567530242
    }
}

class Solution {
    public int sumOfPower(int[] nums) {
        int mod = 1000000007;
        Arrays.sort(nums);
        long res = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            num = (num * num) % mod;

            res = res + (num * sum) % mod + (num * nums[i]) % mod;
            res = res % mod;

            sum = sum << 1;
            sum = sum % mod;
            sum = sum + nums[i];
            sum = sum % mod;
        }
        return (int) res;
    }
}