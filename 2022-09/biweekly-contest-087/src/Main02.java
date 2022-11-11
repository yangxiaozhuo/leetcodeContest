import java.util.Arrays;

/**
 * 2410. 运动员和训练师的最大匹配数
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main02 {
    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);
            int res = 0;
            int index = 0;
            for (int i = 0; i < players.length; i++) {
                while (index<trainers.length && players[i]>trainers[index]) {
                    index++;
                }
                if(index>=trainers.length) break;
                index++;
                res++;
            }
            return res;
        }
    }
}
