package two;

import java.util.HashSet;

/**
 * 817. 链表组件
 *
 * @author yangxiaozhuo
 * @date 2022/10/12
 */
public class Main12 {
    class Solution {
        public int numComponents(ListNode head, int[] nums) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            int res = 0;
            while (head != null && !set.contains(head.val)) {
                head = head.next;
            }
            while (head != null) {
                while (head != null && set.contains(head.val)) {
                    head = head.next;
                }
                while (head != null && !set.contains(head.val)) {
                    head = head.next;
                }
                res++;
            }
            return res;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
