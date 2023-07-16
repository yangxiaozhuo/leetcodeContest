package test03;

import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/06/04
 */
public class Main {
}

class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long res = 0;
        int r = 0;
        int[] rr = new int[n];
        int[] cc = new int[n];
        int c = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            int rc = queries[i][0];
            int index = queries[i][1];
            int val = queries[i][2];
            if (rc == 0 && rr[index] == 0) {
                rr[index] = 1;
                r++;
                res = res + val * (n - c);
            } else if(rc  == 1 && cc[index] == 0){
                c++;
                cc[index] = 1;
                res = res + val*(n - r);
            }
        }
        return res;
    }
}