/**
 * 2409. 统计共同度过的日子数
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main01 {
    class Solution {
        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            String[] aliceArrive = arriveAlice.split("-"); //alice[0] 是月
            String[] aliceLeave = leaveAlice.split("-");

            String[] bobArrive = arriveBob.split("-"); //alice[0] 是月
            String[] bobLeave = leaveBob.split("-");
            int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int[] leave = findMinDay(bobLeave, aliceLeave, true);
            int[] arrive = findMinDay(aliceArrive, bobArrive, false);
            int res = 0;
            if (leave[0] * 100 + leave[1] >= arrive[0] * 100 + arrive[1]) {
                if (leave[0] == arrive[0]) {
                    return leave[1] - arrive[1] + 1;
                }
                for (int i = arrive[0]; i < leave[0] - 1; i++) {
                    res = res + days[i];
                }
                res = res + days[arrive[0] - 1] - arrive[1] + 1;
                res = res + leave[1];
                return res;
            } else {
                return 0;
            }
        }

        public int[] findMinDay(String[] bob, String[] alice, boolean flag) { //flag==true 找小的 false找大的
            int[] res = new int[2];
            int bobMonth = Integer.parseInt(bob[0]);
            int bobDay = Integer.parseInt(bob[1]);
            int aliceMonth = Integer.parseInt(alice[0]);
            int aliceDay = Integer.parseInt(alice[1]);
            if ((bobMonth * 100 + bobDay > aliceMonth * 100 + aliceDay) == flag) {
                res[0] = aliceMonth;
                res[1] = aliceDay;
            } else {
                res[0] = bobMonth;
                res[1] = bobDay;
            }
            return res;
        }
    }
}
