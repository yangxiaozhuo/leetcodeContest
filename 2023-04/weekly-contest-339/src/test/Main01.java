package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangxiaozhuo
 * @date 2023/04/08
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int a = Integer.parseInt(s[2]);
        // 输入
        String[][] site = new String[m][n];
        for (int i = 0; i < site.length; i++) {
            s = in.readLine().split(" ");
            for (int j = 0; j < site[0].length; j++) {
                site[i][j] = s[j];
                //二维字符串数组
            }
        }
        //res是返回值
        int res = 0;
        //遍历每一个行
        for (int i = 0; i < n; i++) {
            //遍历每一列
            for (int j = 0; j < m; j++) {
                //原来的位置
                String origin = site[i][j];
                //新的位置
                String newPosition = site[(i + 1) % n][(j + 1) % m];
                //fun函数，计算原来位置和新位置，有多少不一样
                res = res + fun(origin, newPosition);
            }
        }
        System.out.println(res);
    }

    private static int fun(String origin, String newPosition) {
        int temp = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) != newPosition.charAt(i)) {
                temp++;
            }
        }
        return temp;
    }
}
