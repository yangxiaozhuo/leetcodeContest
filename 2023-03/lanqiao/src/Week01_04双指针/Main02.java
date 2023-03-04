package Week01_04双指针;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 1238. 日志统计
 * https://www.acwing.com/problem/content/1240/
 *
 * @author yangxiaozhuo
 * @date 2023/02/17
 */
public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        int[] nums = new int[100010];
        int[] res = new int[100010];
        int[][] read = new int[n][2];
        for (int i = 0; i < n; i++) {
            s = in.readLine().split(" ");
            int time = Integer.parseInt(s[0]);
            int id = Integer.parseInt(s[1]);
            read[i][0] = time;
            read[i][1] = id;
        }
        Arrays.sort(read, (o1, o2) -> o1[0] - o2[0]);
        HashSet<Integer> set = new HashSet<>();
        int l = 0;
        int r = 0;
        while (r < read.length) {
            while (r < read.length && read[r][0] - read[l][0] < d) {
                nums[read[r][1]]++;
                if (nums[read[r][1]] >= k) {
                    res[read[r][1]] = 1;
                }
                r++;
            }
            nums[read[l][1]]--;
            l++;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 1) {
                System.out.println(i);
            }
        }
    }
}
