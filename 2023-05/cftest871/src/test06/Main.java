package test06;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/05/06
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]); //n个点
            int m = Integer.parseInt(s[1]); //m个边
            int[][] edges = new int[m][2];
            for (int i = 0; i < m; i++) {
                String[] s1 = in.readLine().split(" ");
                int a = Integer.parseInt(s1[0]); //n个点
                int b = Integer.parseInt(s1[1]); //m个边
                edges[i][0] = a;
                edges[i][1] = b;
            }
            System.out.println(fun(edges,n));
        }
    }

    private static String fun(int[][] edges,int n) {
        if (n == 2) {
            return "1 0";
        }
        int[] nums = new int[n + 1];
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            nums[a]++;
            nums[b]++;
        }
        //有n个点   1 + res1 + res1 * res2 == n
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            }
        }
        if (sum + 1 == n) {
            return sum + " " + 0;
        }
        int res1 = n - 1 - sum;
        int res = sum / res1;
        return res1 + " " + res;
    }
}
