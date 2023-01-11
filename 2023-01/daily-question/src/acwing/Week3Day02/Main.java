package acwing.Week3Day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * https://www.acwing.com/problem/content/4457/
 * 
 * @author yangxiaozhuo
 * @date 2023/01/10
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] vis = new int[n + 1];
        int res = 0;
        vis[0] = 1;
        while(k-- > 0) {
            s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if(vis[b] == 0) {
                res++;
            }
            vis[a] = 1;
        }
        System.out.println(res);
    }
}
