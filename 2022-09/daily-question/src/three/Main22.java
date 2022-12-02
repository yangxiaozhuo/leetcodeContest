package three;

import java.util.HashMap;

/**
 * 1640. 能否连接形成数组
 *
 * @author yangxiaozhuo
 * @date 2022/09/22
 */
public class Main22 {
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            HashMap<Integer, int[]> map = new HashMap<>();
            for(int[] piece : pieces) {
                map.put(piece[0], piece);
            }
            for(int i = 0; i < arr.length;) {
                if(!map.containsKey(arr[i])) {
                    return false;
                }
                int[] temp = map.get(arr[i]);
                for(int j = 0; j < temp.length; j++,i++) {
                    if(temp[j]!=arr[i]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
