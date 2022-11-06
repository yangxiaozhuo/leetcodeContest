//2456. 最流行的视频创作者

import java.util.*;

/**
 * 给你两个字符串数组 creators 和 ids ，和一个整数数组 views ，所有数组的长度都是 n 。平台上第 i 个视频者是 creator[i] ，视频分配的 id 是 ids[i] ，且播放量为 views[i] 。
 * 视频创作者的 流行度 是该创作者的 所有 视频的播放量的 总和 。请找出流行度 最高 创作者以及该创作者播放量 最大 的视频的 id 。
 * 如果存在多个创作者流行度都最高，则需要找出所有符合条件的创作者。
 * 如果某个创作者存在多个播放量最高的视频，则只需要找出字典序最小的 id 。
 * 返回一个二维字符串数组 answer ，其中 answer[i] = [creatori, idi] 表示 creatori 的流行度 最高 且其最流行的视频 id 是 idi ，可以按任何顺序返回该结果。
 *
 * 示例 1：
 * 输入：creators = ["alice","bob","alice","chris"], ids = ["one","two","three","four"], views = [5,10,5,4]
 * 输出：[["alice","one"],["bob","two"]]
 * 解释：
 * alice 的流行度是 5 + 5 = 10 。
 * bob 的流行度是 10 。
 * chris 的流行度是 4 。
 * alice 和 bob 是流行度最高的创作者。
 * bob 播放量最高的视频 id 为 "two" 。
 * alice 播放量最高的视频 id 是 "one" 和 "three" 。由于 "one" 的字典序比 "three" 更小，所以结果中返回的 id 是 "one" 。
 */
public class Main02 {
    public static void main(String[] args) {
        String[] creators = {"alice","bob","alice","chris"};
        String[] ids = {"one","two","three","four"};
        int[] views = {5,10,5,4};
        Solution solution = new Solution();
        System.out.println(solution.mostPopularCreator(creators, ids, views));
    }
    static class Solution {
        public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
            List<List<String>> res = new ArrayList<>();
            PriorityQueue<Object[]> queue = new PriorityQueue<>((o1, o2) -> (int)o2[1]-(int)o1[1]);
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < views.length; i++) {
                map.put(creators[i], map.getOrDefault(creators[i], 0) + views[i]);
            }
            for (Map.Entry<String,Integer> entry : map.entrySet()) {
                queue.add(new Object[]{entry.getKey(),entry.getValue()});
            }
            HashSet<String> set = new HashSet<>();
            Object[] poll = queue.poll();
            int max = (int)poll[1];
            set.add((String) poll[0]);
            while (!queue.isEmpty() && (int)queue.peek()[1] == max) {
                poll = queue.poll();
                set.add((String) poll[0]);
            }
            HashMap<String, String[]> resmap = new HashMap<>();
            for (int i = 0; i < creators.length; i++) {
                if (set.contains(creators[i])) {
                    if (resmap.containsKey(creators[i])) {
                        String[] strings = resmap.get(creators[i]);
                        if (views[i] > Integer.parseInt(strings[1]) || (views[i] == Integer.parseInt(strings[1]) && ids[i].compareTo(strings[0]) < 0)) {
                            resmap.put(creators[i],new String[]{ids[i],""+views[i]});
                        }
                    } else {
                        resmap.put(creators[i],new String[]{ids[i],""+views[i]});
                    }
                }
            }
            for (Map.Entry<String,String[]> entry : resmap.entrySet()) {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(entry.getKey());
                strings.add(entry.getValue()[0]);
                res.add(new ArrayList<>(strings));
            }
            return res;
        }
    }
}
