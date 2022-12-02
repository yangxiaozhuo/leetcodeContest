/**
 * 2487. 从链表中移除节点
 *
 * @author yangxiaozhuo
 * @date 2022/11/27
 */
public class Main03 {
    class Solution {
        public ListNode removeNodes(ListNode head) {
            int[] arr = new int[100000];
            int index = 0;
            while (head != null) {
                arr[index] = head.val;
                head = head.next;
                index++;
            }
            int max = 0;
            for (int i = index - 1; i >= 0; i--) {
                if (max > arr[i]) {
                    arr[i] = -1;
                } else {
                    max = arr[i];
                }
            }
            ListNode res = new ListNode(0);
            ListNode cur = res;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != -1) {
                    cur.next = new ListNode(arr[i]);
                    cur = cur.next;
                }
            }
            return res.next;
        }
    }

    public class ListNode {
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
