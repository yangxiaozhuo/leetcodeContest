package b;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int[] nums = new int[1000000010];
        String s1 = in.readLine();
        String[] s = in.readLine().split(" ");
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            int t = Integer.parseInt(s[i]);
            index = Math.max(index, t);
            nums[t]++;
        }
        s = in.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            int t = Integer.parseInt(s[i]);
            index = Math.max(index, t);
            nums[t + 1]--;
        }
        int max = 0;
        int maxNum = 0;
        int sum = 0;
        for (int i = 0; i <= index; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
                maxNum = 1;
            } else if (sum == max) {
                maxNum++;
            }
        }
        out.println(max + " " + maxNum);
        out.flush();
    }
}
