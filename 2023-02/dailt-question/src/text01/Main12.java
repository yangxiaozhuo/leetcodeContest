package text01;

/**
 * @author yangxiaozhuo
 * @date 2023/02/12
 */
public class Main12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alphabetBoardPath("dnasodhnawoiubznasoudiwuabzawaeidubizoipawndowqnz"));
    }

    static class Solution {
        public String alphabetBoardPath(String target) {
            String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
            StringBuilder res = new StringBuilder();
            int l = 0;
            int r = 0;
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                while (true) {
                    char at = board[l].charAt(r);
                    if (c == at) {
                        res.append("!");
                        break;
                    } else if (c > at) {
                        int t = (c - at) % 5;
                        if (4 - r < t) {
                            r--;
                            res.append("L");
                        } else if (t == 0) {
                            l++;
                            res.append("D");
                        } else {
                            r++;
                            res.append("R");
                        }
                    } else {
                        int t = (at - c) % 5;
                        if (t == 0) {
                            l--;
                            res.append("U");
                        } else if (r >= t) {
                            r--;
                            res.append("L");
                        } else {
                            l--;
                            res.append("U");
                        }
                    }
                }
            }
            return res.toString();
        }
    }
}
