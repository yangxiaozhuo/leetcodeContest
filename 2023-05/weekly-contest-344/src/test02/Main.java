package test02;

import java.util.HashMap;

/**
 * @author yangxiaozhuo
 * @date 2023/05/07
 */
public class Main {
}

class FrequencyTracker {
    HashMap<Integer, Integer> map;
    int[] times;

    public FrequencyTracker() {
        map = new HashMap<>();
        times = new int[100010];
    }

    public void add(int number) {
        int temp = map.getOrDefault(number, 0);
        map.put(number, temp + 1);
        times[temp + 1]++;
        if (temp != 0) {
            times[temp]--;
        }
    }

    public void deleteOne(int number) {
        int temp = map.getOrDefault(number, 0);
        if (temp == 0) {
            return;
        }
        map.put(number, temp - 1);
        times[temp - 1]++;
        times[temp]--;
    }

    public boolean hasFrequency(int frequency) {
        return times[frequency] > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */