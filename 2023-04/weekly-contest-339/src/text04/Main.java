package text04;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/04/02
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.minReverseOperations(3, 2, new int[0], 2))); //[2,1,0]
//        System.out.println(Arrays.toString(solution.minReverseOperations(4, 3, new int[0], 2))); //[3,2,1,0]
//        System.out.println(Arrays.toString(solution.minReverseOperations(4, 0, new int[]{1}, 4))); // [0,-1,-1,1]
//        System.out.println(Arrays.toString(solution.minReverseOperations(3, 1, new int[]{2}, 3))); //[-1,0,-1]
//        System.out.println(Arrays.toString(solution.minReverseOperations(5, 0, new int[]{}, 4))); //[0,3,2,1,4]
        System.out.println(Arrays.toString(solution.minReverseOperations(5, 3, new int[]{2}, 2))); //[-1,-1,-1,0,1]
//        System.out.println(Arrays.toString(solution.minReverseOperations(10000, 0, new int[]{}, 4)));
    }
}

class Solution {
    int k;

    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        this.k = k;
        int[] res = new int[n];
        if (k == 1) {
            Arrays.fill(res, -1);
            res[p] = 0;
            return res;
        }
        Arrays.fill(res, -1);
        res[p] = 0;
        for (int i = p + k - 1; i < n; i = i + k - 1) {
            res[i] = res[i - k + 1] + 1;
        }
        for (int i = p - k + 1; i >= 0; i = i - k + 1) {
            res[i] = res[i + k - 1] + 1;
        }
        for (int i = 0; i < n - k + 1; i++) {
            dfs(i, i + k - 1, res);
        }
        for (int i = 0; i < banned.length; i++) {
            res[banned[i]] = -1;
        }
        int[] dp = new int[n];
        for (int i = 0; i < res.length; i++) {
            if (res[i] != -1)
                dp[res[i]]++;
        }
        int max = n;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) {
                max = i;
                break;
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] >= max){
                res[i] = -1;
            }
        }
//        for (int i = 0; i < banned.length; i++) {
//            res[banned[i]] = -1;
//        }
        return res;
    }

    private void dfs(int l, int r, int[] res) {
        if (l < 0 || r >= res.length) {
            return;
        }
        while (l < r) {
            if (res[l] != -1 && res[r] == -1) {
                res[r] = res[l] + 1;
                for (int i = r - k + 1; i < r; i++) {
                    dfs(i, i+k - 1, res);
                }
            }
            if (res[l] == -1 && res[r] != -1) {
                res[l] = res[r] + 1;
                for (int i = l - k + 1; i < l; i++) {
                    dfs(i, i+k - 1, res);
                }
            }
            if (res[l] != -1 && res[r] != -1) {
                if (res[l] + 1 < res[r]) {
                    res[r] = res[l] + 1;
                    for (int i = r - k + 1; i < r; i++) {
                        dfs(i, i+k - 1, res);
                    }
                } else if (res[r] + 1 < res[l]) {
                    res[l] = res[r] + 1;
                    for (int i = l - k + 1; i < l; i++) {
                        dfs(i, i+k - 1, res);
                    }
                }
            }
            l++;
            r--;
        }
    }
}