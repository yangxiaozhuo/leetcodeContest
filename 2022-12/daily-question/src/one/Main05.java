package one;

import java.util.ArrayList;

/**
 * 1687. 从仓库到码头运输箱子  //不会 
 *
 * @author yangxiaozhuo
 * @date 2022/12/05
 */
public class Main05 {
    public static void main(String[] args) {
        int[][] boxes = new int[][]{{1, 2},{3,3},{3,1},{3,1},{2,4}};
        Solution solution = new Solution();
        System.out.println(solution.boxDelivering(boxes, 3, 3, 6));

    }

    static class Solution {
        int res = 0;

        public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
            res = boxes.length * 2;
            dfs(boxes, maxBoxes, maxWeight, 0, 0, 0, 0);
            return res;
        }

        private void dfs(int[][] boxes, int maxBoxes, int maxWeight, int index, int haveBoxes, int haveWeight, int temp) {
            if (temp > res || haveBoxes > maxBoxes || haveWeight > maxWeight) {
                return;
            }
            if (index == boxes.length) {
                res = Math.min(res, temp);
                return;
            }
            ArrayList<int[]> arrayList = new ArrayList<>();
            if (haveBoxes == 0) {
                arrayList.add(boxes[index]);
                haveBoxes++;
                haveWeight = haveWeight + boxes[index][1];
                index++;
                dfs(boxes, maxBoxes, maxWeight, index, 0, 0, temp+ fun(arrayList));
            }
            while (arrayList.size() < maxBoxes && index < boxes.length) {
                arrayList.add(boxes[index]);
                haveBoxes++;
                haveWeight = haveWeight + boxes[index][1];
                index++;
                dfs(boxes, maxBoxes, maxWeight, index, haveBoxes, haveWeight , temp + fun(arrayList));
                dfs(boxes, maxBoxes, maxWeight, index, 0, 0, temp+ fun(arrayList));
            }
        }

        private int fun(ArrayList<int[]> arrayList) {
            int at = 0;
            int res = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                int[] ints = arrayList.get(i);
                if (ints[0] != at) {
                    at = ints[0];
                    res++;
                }
            }
            return res + 1;
        }
    }
}
