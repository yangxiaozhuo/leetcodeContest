package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * @author yangxiaozhuo
 * @date 2023/02/02
 */
public class Main118 {
    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            res.add(temp);
            for (int i = 1; i < numRows; i++) {
                ArrayList<Integer> inner = new ArrayList<>();
                inner.add(1);
                List<Integer> pre = res.get(i - 1);
                for (int j = 0; j < pre.size() - 1; j++) {
                    inner.add(pre.get(i) + pre.get(i +1));
                }
                inner.add(1);
                res.add(inner);
            }
            return res;
        }
    }
}
