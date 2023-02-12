package text03;

import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[100000][2];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(new Random().nextInt(2));
        }
        for (int i = 0; i < 100000; i++) {
            ints[i][0] = new Random().nextInt(1000000000);
            ints[i][1] = new Random().nextInt(1000000000 - ints[i][0]);
        }
        long l = System.currentTimeMillis();
        System.out.println(Arrays.deepToString(solution.substringXorQueries(stringBuilder.toString(), ints)));
        long r = System.currentTimeMillis();
        System.out.println(r - l);
//        System.out.println(Arrays.deepToString(solution.substringXorQueries("101101", new int[][]{{0,5},{1,2}})));
    }
}

class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        HashMap<Integer, int[]> map = new HashMap<>(queries.length * 2);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (!map.containsKey(0)) {
                    map.put(0, new int[]{i, i});
                }
                continue;
            }
            long temp = 0;
            for (int j = i; j < s.length(); j++) {
                temp = temp * 2 + s.charAt(j) - '0';
                if (temp > Integer.MAX_VALUE) {
                    break;
                } else {
                    if (!map.containsKey((int)temp)) {
                        map.put((int) temp, new int[]{i, j});
                    }
                }
            }
        }
        int[][] res = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i][0] ^ queries[i][1];
            if (map.containsKey(temp)) {
                res[i] = map.get(temp);
            }else {
                res[i] = new int[]{-1,-1};
            }
        }
        return res;
    }

    private String to2(int temp) {
        if (temp == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (temp != 0) {
            sb.append(temp % 2);
            temp = temp / 2;
        }
        return sb.reverse().toString();
    }
}

class Solution2 {
    public int[][] substringXorQueries(String s, int[][] queries) {
        HashMap<Integer, int[]> map = new HashMap<>(queries.length * 2);
        int[][] res = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i][0] ^ queries[i][1];
            if (map.containsKey(temp)) {
                res[i] = map.get(temp);
                continue;
            }
            String target = Integer.toString(temp, 2);
//            String target = to2(temp);
            if (target.length() > s.length()) {
                res[i][0] = -1;
                res[i][1] = -1;
                map.put(temp, res[i]);
                continue;
            }
            int t = s.indexOf(target);
            if (t == -1) {
                res[i][0] = -1;
                res[i][1] = -1;
            } else {
                res[i][0] = t;
                res[i][1] = t + target.length() - 1;
            }
            map.put(temp, res[i]);
        }
        return res;
    }

    private String to2(int temp) {
        if (temp == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (temp != 0) {
            sb.append(temp % 2);
            temp = temp / 2;
        }
        return sb.reverse().toString();
    }
}