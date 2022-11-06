package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 870. 优势洗牌
 *
 * @author yangxiaozhuo
 * @date 2022/10/08
 */
public class Main08 {
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            int[] newNums2 = Arrays.copyOf(nums2, nums2.length);
            Arrays.sort(nums2);
            for (int i = 0; i < nums1.length / 2; i++) {
                swap(nums1, i, nums1.length - 1 - i);
                swap(nums2, i, nums1.length - 1 - i);
            }//从大到小排列
            int index1 = 0;
            int index2 = 0;
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            while (index2 < nums1.length) {
                if (nums1[index1] > nums2[index2]) {
                    if (map.containsKey(nums2[index2])) {
                        map.get(nums2[index2]).add(nums1[index1]);
                    } else {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        arrayList.add(nums1[index1]);
                        map.put(nums2[index2], arrayList);
                    }
                    index1++;
                    index2++;
                } else {
                    index2++;
                }
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                int t = newNums2[i];
                if (!map.containsKey(t)) {
                    res[i] = nums1[index1++];
                } else {
                    ArrayList<Integer> arrayList = map.get(t);
                    res[i] = arrayList.remove(0);
                    if (arrayList.size() == 0) {
                        map.remove(t);
                    }
                }
            }
            return res;
        }

        private void swap(int[] nums1, int i, int i1) {
            int t = nums1[i];
            nums1[i] = nums1[i1];
            nums1[i1] = t;
        }
    }
}
