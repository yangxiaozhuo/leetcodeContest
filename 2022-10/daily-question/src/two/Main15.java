package two;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 *
 * @author yangxiaozhuo
 * @date 2022/10/12
 */
public class Main15 {
    class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> res = new ArrayList<>();
            int index = 1;
            for (int i = 0; i < target.length; i++, index++) {
                while (target[i] > index) {
                    res.add("Push");
                    res.add("Pop");
                    index++;
                }
                res.add("Push");
            }
            return res;
        }
    }
}
