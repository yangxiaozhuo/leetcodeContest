package baidu01;

import java.io.*;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/03/13
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String s = in.readLine();
            if (fun(s)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
        out.flush();
    }

    private static boolean fun(String s) {
        if (s.length() != 5) {
            return false;
        }
        HashSet<Character> set = new HashSet<>();
        set.add('B');
        set.add('a');
        set.add('i');
        set.add('d');
        set.add('u');
        for (char c : s.toCharArray()) {
            set.remove(c);
        }
        return set.size() == 0;
    }
}
