/**
 * @author yangxiaozhuo
 * @date 2023/01/08
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isItPossible("ab", "aa"));
    }

    static class Solution {
        public boolean isItPossible(String word1, String word2) {
            int[] a = new int[26];
            int[] b = new int[26];
            int anum = 0;
            int bnum = 0;
            for (char c : word1.toCharArray()) {
                a[c - 'a']++;
            }
            for (char c : word2.toCharArray()) {
                b[c - 'a']++;
            }
            for (int i = 0; i < a.length; i++) {
                if (a[i] != 0) {
                    anum++;
                }
                if (b[i] != 0) {
                    bnum++;
                }
            }
            if (Math.abs(anum - bnum) > 2) {
                return false;
            }
            for (int i = 0; i < 26; i++) {
                if (a[i] == 0) {
                    continue;
                }
                for (int j = 0; j < 26; j++) {
                    if (b[j] == 0) {
                        continue;
                    }
                    if (i == j) {
                        if (anum == bnum) {
                            return true;
                        }else {
                            continue;
                        }
                    }
                    int t = 0;
                    if (a[i] - 1 == 0) {
                        t--;
                    }
                    if (a[j] == 0) {
                        t++;
                    }
                    if(b[j] - 1== 0) {
                        t++;
                    }
                    if (b[i] == 0) {
                        t--;
                    }
                    if(anum + t == bnum) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
