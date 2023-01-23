package two;

import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/01/20
 */
public class Main20 {
    class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            int[] res = new int[k];
            Arrays.sort(logs,(o1,o2)-> {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            });
            int r = 0;
            while (r < logs.length) {
                int num = 0;
                while (r < logs.length && logs[r][0] == logs[r][1]) {
                    if (num == 0 || logs[r][1] != logs[r - 1][1]) {
                        num++;
                    }
                    r++;
                }
                res[num]++;
            }
            return res;
        }
    }
}
