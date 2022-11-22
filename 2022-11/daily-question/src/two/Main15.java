package two;

import java.util.Arrays;

/**
 * 1710. 卡车上的最大单元数
 *
 * @author yangxiaozhuo
 * @date 2022/11/15
 */
public class Main15 {
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
            int res = 0;
            int index = 0;
            while (index < boxTypes.length && truckSize != 0) {
                if (boxTypes[index][0] >= truckSize) {
                    return res + truckSize * boxTypes[index][1];
                } else {
                    res = res + boxTypes[index][0] * boxTypes[index][1];
                    truckSize -= boxTypes[index][0];
                    index++;
                }
            }
            return res;
        }
    }
}
