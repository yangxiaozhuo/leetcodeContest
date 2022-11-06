package three;

import java.util.HashMap;
import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量
 *
 * @author yangxiaozhuo
 * @date 2022/10/29
 */
public class Main29 {
    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int index = new HashMap<String, Integer>() {{
                put("type", 0);
                put("color", 1);
                put("name", 2);
            }}.get(ruleKey);
            int res = 0;
            for (List<String> item : items) {
                if (item.get(index).equals(ruleValue)) {
                    res++;
                }
            }
            return res;
        }
    }
}
