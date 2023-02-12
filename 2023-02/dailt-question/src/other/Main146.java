package other;

import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;

import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/02/12
 */
public class Main146 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < 10000; i++) {
            sb.append("[0," + i + "],");
        }
        sb.append(']');
        System.out.println(sb.toString());
    }
}

class LRUCache {
    int[][] val = new int[100010][2];  //key value
    int[] pre = new int[100010];
    int[] ne = new int[100010];
    int index = 2;
    HashMap<Integer, Integer> map = new HashMap<>();//key -pos
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        Arrays.fill(pre, -1);
        Arrays.fill(ne, -1);
        ne[0] = 1;
        pre[1] = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int pos = map.get(key);
        int res = val[pos][1];
        remove(pos);
        addLast(key, res);
        return res;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            int pos = map.get(key);
            val[pos][1] = value;
            get(key);
            return;
        }
        if (map.size() < cap) {
            addLast(key, value);
        } else {
            removeFirst();
            put(key, value);
        }
    }

    private void removeFirst() {
        int pos = ne[0];
        ne[0] = ne[pos];
        pre[ne[pos]] = 0;
        map.remove(val[pos][0]);
    }

    private void addLast(int key, int res) {
        val[index][1] = res;
        val[index][0] = key;
        ne[index] = 1;
        pre[index] = pre[1];
        ne[pre[1]] = index;
        pre[1] = index;
        map.put(key, index);
        index++;
    }

    private void remove(int pos) {
        ne[pre[pos]] = ne[pos];
        pre[ne[pos]] = pre[pos];
        map.remove(val[pos][0]);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
