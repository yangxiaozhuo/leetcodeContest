package mayi01;

import java.io.*;

/**
 * @author yangxiaozhuo
 * @date 2023/03/16
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String s = in.readLine();
        long ou = 0;
        long ji = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            if (c % 2 == 0) {
                ou = ou * 10 + c;
            } else {
                ji = ji * 10 + c;
            }
        }
        out.println(Math.abs(ji - ou));
        out.flush();
    }
}
