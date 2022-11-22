package two;

import java.util.ArrayList;

/**
 * 792. 匹配子序列的单词数
 *
 * @author yangxiaozhuo
 * @date 2022/11/17
 */
public class Main17 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcde";
        String[] word = {"a", "bb", "acd", "ace"};
        System.out.println(solution.numMatchingSubseq(s, word));
    }

    static class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            int[][] lists = new int[26][50010];
            int[] nums = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int t = s.charAt(i) - 'a';
                lists[t][nums[t]] = i;
                nums[t]++;
            }
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                if(fun(lists, words[i],nums)) {
                    res++;
                }
            }
            return res;
        }

        private boolean fun(int[][] lists, String word, int[] nums) {
            int index = -1;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (nums[c] == 0 || lists[c][nums[c] - 1] <= index) {
                    return false;
                }
                index = find(lists[c], index, nums[c]-1);
            }
            return true;
        }

        private int find(int[] list, int index,int r) {
            int l = 0;
            while (l < r) {
                int mid = l + r >> 1;
                if (list[mid] <= index) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return list[r];
        }
    }
    static class Solution1 {
        public int numMatchingSubseq(String s, String[] words) {
            ArrayList<Integer>[] lists = new ArrayList[26];
            for (int i = 0; i < lists.length; i++) {
                lists[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < s.length(); i++) {
                lists[s.charAt(i) - 'a'].add(i);
            }
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                if(fun(lists, words[i])) {
                    res++;
                }
            }
            return res;
        }

        private boolean fun(ArrayList<Integer>[] lists, String word) {
            int index = -1;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (lists[c].size() == 0 || lists[c].get(lists[c].size() - 1) <= index) {
                    return false;
                }
                index = find(lists[c], index);
            }
            return true;
        }

        private int find(ArrayList<Integer> list, int index) {
            int l = 0;
            int r = list.size();
            while (l < r) {
                int mid = l + r >> 1;
                if (list.get(mid) <= index) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return list.get(r);
        }
    }
}
