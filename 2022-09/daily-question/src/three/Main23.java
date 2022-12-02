package three;

/**
 * 707. 设计链表
 *
 * @author yangxiaozhuo
 * @date 2022/09/23
 */
public class Main23 {
    class MyLinkedList {
        int size;
        Node start;
        public class Node{
            int val;
            Node next;

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }
        public MyLinkedList() {
            size = 0;
            start = new Node(0,null);
        }

        public int get(int index) {
            if(index > size - 1 || index < 0) {
                return -1;
            }
            Node cur = start.next;
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            size++;
            Node fast = new Node(val, start.next);
            start.next = fast;
        }

        public void addAtTail(int val) {
            size++;
            Node cur = start;
            while(cur.next!=null) {
                cur = cur.next;
            }
            cur.next = new Node(val,null);
        }

        public void addAtIndex(int index, int val) {
            if(index <= 0){
                addAtHead(val);
                return;
            }
            if(index == size) {
                addAtTail(val);
                return;
            }
            if(index > size) {
                return;
            }
            size++;
            Node cur = start;
            int t = index;
            while(t > 0) {
                cur = cur.next;
                t--;
            }
            cur.next = new Node(val,cur.next);
        }

        public void deleteAtIndex(int index) {
            if(index < 0 || index >= size) {
                return;
            }
            size--;
            Node cur = start;
            int t = index;
            while(t > 0) {
                cur = cur.next;
                t--;
            }
            cur.next = cur.next.next;
        }
    }
}
