package Week01_04双指针;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3768. 字符串删减
 * https://www.acwing.com/problem/content/3771/
 *
 * @author yangxiaozhuo
 * @date 2023/02/17
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
        int res = 0;
        int temp = 0;
        for (char c : s.toCharArray()) {
            if (c != 'x') {
                temp = 0;
            } else {
                temp++;
                if (temp > 2) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
