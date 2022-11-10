package one;

/**
 * 864. 获取所有钥匙的最短路径
 *
 * @author yangxiaozhuo
 * @date 2022/11/10
 */
public class Main10 {
    //hard题自己做的回溯+dfs，做是可以做，但是超时了
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] grid = new String[]{".@aA"};
        System.out.println(solution.shortestPathAllKeys(grid));
    }

    static class Solution {
        public int shortestPathAllKeys(String[] grid) {
            char[][] world = new char[grid.length][grid[0].length()];
            for (int i = 0; i < grid.length; i++) {
                world[i] = grid[i].toCharArray();
            }
            int num = 0;  //钥匙的个数
            int starti = 0;  //起点的i和j
            int startj = 0;
            for (int i = 0; i < world.length; i++) {
                for (int j = 0; j < world[0].length; j++) {
                    if (world[i][j] <= 'f' && world[i][j] >= 'a') {
                        num++;
                    }
                    if (world[i][j] == '@') {
                        starti = i;
                        startj = j;
                    }
                }
            }
            int[][] position = new int[num][2];   //记录每个钥匙所在位置
            for (int i = 0; i < world.length; i++) {
                for (int j = 0; j < world[0].length; j++) {
                    if (world[i][j] <= 'f' && world[i][j] >= 'a') {
                        position[world[i][j] - 'a'][0] = i;
                        position[world[i][j] - 'a'][1] = j;
                    }
                }
            }
            int res = fun(world, new int[num], position, starti, startj);
            if (res == Integer.MAX_VALUE) {
                return -1;
            }
            return res;
        }

        //给起点，拿完剩下的钥匙的最短路径
        private int fun(char[][] world, int[] have, int[][] position, int starti, int startj) {
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < have.length; i++) {
                if (have[i] == 0) {
                    int temp = dfs(world, have, starti, startj, position[i][0], position[i][1], 0, new int[world.length][world[0].length]); //求出start到end的最短路径
                    if (temp == -1) {  //走不过去
                        continue;
                    } else {  //走的guoqu
                        have[i] = 1;
                        res = Math.min(res, temp+ fun(world, have, position, position[i][0], position[i][1])) ;
                        have[i] = 0;
                    }
                }
            }
            int t = 0;
            for (int i = 0; i < have.length; i++) {
                t += have[i];
            }
            if (t == have.length) {
                return 0;
            }
            if (res < 0) {
                return Integer.MAX_VALUE;
            }
            return res;
        }

        private int dfs(char[][] world, int[] have, int i, int j, int endi, int endj, int res, int[][] vis) {
            if (i < 0 || j < 0 || i >= world.length || j >= world[0].length || world[i][j] == '#' || vis[i][j] == 1) {
                return -1;
            }
            if (world[i][j] <= 'F' && world[i][j] >= 'A') {
                if (have[world[i][j] - 'A'] == 0) {
                    return -1;
                }
            }
            if (i == endi && j == endj) {
                return res;
            }
            vis[i][j] = 1;
            int temp = Integer.MAX_VALUE;
            int dfs = dfs(world, have, i - 1, j, endi, endj, res + 1, vis);
            if (dfs > 0) {
                temp = Math.min(temp, dfs);
            }
            dfs = dfs(world, have, i, j - 1, endi, endj, res + 1, vis);
            if (dfs > 0) {
                temp = Math.min(temp, dfs);
            }
            dfs = dfs(world, have, i + 1, j, endi, endj, res + 1, vis);
            if (dfs > 0) {
                temp = Math.min(temp, dfs);
            }
            dfs = dfs(world, have, i, j + 1, endi, endj, res + 1, vis);
            if (dfs > 0) {
                temp = Math.min(temp, dfs);
            }
            vis[i][j] = 0;
            if (temp == Integer.MAX_VALUE) {
                return -1;
            }
            return temp;
        }
    }
}
