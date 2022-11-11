import java.util.PriorityQueue;

/**
 * 2418. 按身高排序
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main01 {
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            String[] res = new String[names.length];
            PriorityQueue<Object[]> queue = new PriorityQueue<>((o1, o2) -> {
                return (Integer)o2[1] - (Integer)o1[1];
            });
            for (int i = 0; i < heights.length; i++) {
                queue.add(new Object[]{names[i],heights[i]});
            }
            int index = 0;
            while (!queue.isEmpty()) {
                res[index++] = (String) queue.poll()[0];
            }
            return res;
        }
    }
}
