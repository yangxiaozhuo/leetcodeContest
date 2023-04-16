package other;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String s = in.readLine();
        int k = Integer.parseInt(in.readLine());
        out.println(fun(s, k));
        out.flush();
    }

    private static String fun(String s, int k) {
        char[] chars = s.toCharArray();
        return s.substring(k) + s.substring(0, k);
    }
}
