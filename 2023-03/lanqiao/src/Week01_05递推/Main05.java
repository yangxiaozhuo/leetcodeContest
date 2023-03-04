package Week01_05递推;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1208. 翻硬币
 * https://www.acwing.com/problem/content/1210/
 *
 * @author yangxiaozhuo
 * @date 2023/02/20
 */
public class Main05 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] origin = in.readLine().toCharArray();
        char[] target = in.readLine().toCharArray();
        int t = 0;
        for (int i = 0; i < origin.length - 1; i++) {
            if (origin[i] != target[i]) {
                change(origin, i);
                t++;
            }
        }
        System.out.println(t);
    }

    private static void change(char[] origin, int i) {
        origin[i] = origin[i] == '*' ? 'o' : '*';
        origin[i + 1] = origin[i + 1] == '*' ? 'o' : '*';
    }
}
