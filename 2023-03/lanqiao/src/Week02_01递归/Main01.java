package Week02_01递归;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * 1497. 树的遍历
 * https://www.acwing.com/problem/content/1499/
 *
 * @author yangxiaozhuo
 * @date 2023/02/20
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] follow = new int[n];
        int[] middle = new int[n];
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < follow.length; i++) {
            follow[i] = Integer.parseInt(s[i]);
        }
        s = in.readLine().split(" ");
        for (int i = 0; i < middle.length; i++) {
            middle[i] = Integer.parseInt(s[i]);
        }
        int[] res = new int[n];
        int index = 0;
        Node root = fun(middle, 0, middle.length - 1, follow, 0, follow.length - 1);
        ArrayDeque<Node> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (index < n) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                Node node = nodes.removeFirst();
                res[index++] = node.val;
                if (node.left != null) {
                    nodes.addLast(node.left);
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                }
            }
        }
        StringBuilder sber = new StringBuilder();
        for (int num : res) {
            sber.append(num);
            sber.append(" ");
        }
        System.out.println(sber.toString());
    }

    private static Node fun(int[] middle, int a, int b, int[] follow, int x, int y) {
        if (x > y) {
            return null;
        }
        Node node = new Node(follow[y], null, null);
        for (int i = a; i <= b; i++) {
            if (middle[i] == follow[y]) {
                //
                node.left = fun(middle, a, i - 1, follow, x, x + i - a - 1);
                node.right = fun(middle, i + 1, b, follow, y - b + i, y - 1);
            }
        }
        return node;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public Node() {
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
