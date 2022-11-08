package one;

/**
 * 754. 到达终点数字
 *
 * @author yangxiaozhuo
 * @date 2022/11/04
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 你可以做一些数量的移动 numMoves :
 * 每次你可以选择向左或向右移动。
 * 第 i次移动（从 i == 1开始，到i == numMoves ），在选择的方向上走 i步。
 * 给定整数target ，返回 到达目标所需的 最小移动次数(即最小 numMoves )。
 * <p>
 * 示例 1:
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reachNumber(2));
    }
    static class Solution {
        public int reachNumber(int target) {
            target = Math.abs(target);
            int res = 0;
            int dis = 0;
            while(dis < target){
                res++;
                dis += res;

            }
            int dt= dis - target;
            if(dt % 2 == 0)
                return res;
            else{
                if(res % 2 == 0)
                    return res + 1;
                else
                    return res + 2;
            }
        }
    }
}
