package Week02_02并查集;

import java.io.*;

/**
 * 1249. 亲戚
 * https://www.acwing.com/problem/content/1251/
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wt = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] up = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            up[i] = i;
        }
        while(m -- > 0) {
            s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int root1=find(up, a);
            int root2=find(up, b);
            if(root1!=root2) up[root2] = root1;
        }
        m = Integer.parseInt(in.readLine());
        while(m -- > 0) {
            s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if(find(up, a) == find(up, b)) {
                wt.println("Yes");
            } else {
                wt.println("No");
            }
        }
        wt.flush();
    }
    public static int find(int[] up, int num) {
        if(up[num] == num) {
            return num;
        }
        up[num] = find(up, up[num]);
        return up[num];
    }
}