package text01;

import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/02/08
 */
public class Main07 {
    class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            HashMap<String, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < keyName.length; i++) {
                ArrayList<Integer> temp;
                if (map.containsKey(keyName[i])) {
                    temp = map.get(keyName[i]);
                }else {
                    temp = new ArrayList<>();
                    map.put(keyName[i],temp);
                }
                temp.add(fun(keyTime[i]));
            }
            ArrayList<String> res = new ArrayList<>();
            for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
                ArrayList<Integer> value = entry.getValue();
                Collections.sort(value);
                for (int i = 2; i < value.size(); i++) {
                    if (value.get(i) - value.get(i - 2) <= 60) {
                        res.add(entry.getKey());
                        break;
                    }
                }
            }
            Collections.sort(res);
            return res;
        }

        private Integer fun(String s) {
            return (s.charAt(0) - '0') * 60 * 10 + (s.charAt(1) - '0') * 60 + (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
        }
    }
}
