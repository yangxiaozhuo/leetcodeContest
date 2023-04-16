package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yangxiaozhuo
 * @date 2023/04/08
 */
public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int[] nums = new int[n];
        //s是1，2，3，4，5，3
        //nums是 _, 1，2，3，4，5，3   和s错开一位
        for (int i = 1; i < n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
        }
        //map里面的key是序号为key的点，value是一个array，里面装着和val相连的点
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        //建图
        for (int i = 1; i < nums.length; i++) {
            //nums[i] = t  说明两个点i + 1和t相连
            if (!map.containsKey(i + 1)) {  //如果map里面没记录过i，就新建arr
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                map.put(i + 1, temp);
            } else {
                //如果记录过i， 就取出来i的arr,添加nums[i]
                ArrayList<Integer> temp = map.get(i + 1);
                temp.add(nums[i]);
            }
            //nums[i]同理
            if (!map.containsKey(nums[i])) {  //如果map里面没记录过nums[i]，就新建arr
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i + 1);
                map.put(nums[i], temp);
            } else {
                //如果记录过nums[i]， 就取出来i的arr,添加i
                ArrayList<Integer> temp = map.get(nums[i]);
                temp.add(i + 1);
            }
        }
        int res = 2;
        s = in.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int[] vis = new int[n + 1]; //作为一个标记数组 1 到 7
        vis[a] = 1;
        vis[b] = 1;
        dfs(a, vis, map, 0); //此时在a点，已经走了0个数
        res += max;
        max = 0;
        dfs(b, vis, map, 0);
        res += max;
        System.out.println(res - 1);
    }

    static int max = 0;

    private static void dfs(int at, int[] vis, HashMap<Integer, ArrayList<Integer>> map, int depth) {
        max = Math.max(max, depth);
        ArrayList<Integer> next = map.get(at);  //拿出a的临边
        if (next == null) {
            return;
        }
        for (int t : next) {
            if (vis[t] == 0) {
                vis[t] = 1;
                dfs(t, vis, map, depth + 1);
            }
        }
    }
}
