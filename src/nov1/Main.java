package nov1;

import java.util.Stack;

public class Main {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            String ans = "";
            if (this.left == null) ans += "null <=";
            else ans += this.left.data + " <=";
            ans += " " + this.data + " ";
            if (this.right == null) ans += "=> null";
            else ans += "=> " + this.right.data;
            return ans;
        }
    }

    static class ConstructTreeHelp {
        Node node;
        int state; //0,1,2

        public ConstructTreeHelp(Node node) {
            this.node = node;
            this.state = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 40, -1, -1, 50, 80, -1, -1, -1, 30, 60, -1, 90, -1, -1, 70, -1, -1};
        Node root = constructBt(arr);
        displayPost(root);
    }

    public static Node constructBt(int[] arr) {
        Stack<ConstructTreeHelp> st = new Stack<>();
        Node root = new Node(arr[0]);
        ConstructTreeHelp firstNode = new ConstructTreeHelp(root);
        st.push(firstNode);
        int i = 1;
        while (i < arr.length) {
            ConstructTreeHelp peek = st.peek();
            int curr = arr[i];
            if (peek.state == 0) {
                if (curr != -1) {
                    Node node = new Node(curr);
                    peek.node.left = node;
                    st.push(new ConstructTreeHelp(node));
                }
                peek.state++;
                i++;
            } else if (peek.state == 1) {
                if (curr != -1) {
                    Node node = new Node(curr);
                    peek.node.right = node;
                    st.push(new ConstructTreeHelp(node));
                }
                peek.state++;
                i++;
            } else {
                st.pop();
            }
        }
        return root;
    }

    public static void displayPre(Node root) {
        if (root == null) return;
        System.out.println(root);
        displayPre(root.left);
        displayPre(root.right);
    }

    public static void displayIn(Node root) {
        if (root == null) return;
        displayIn(root.left);
        System.out.println(root);
        displayIn(root.right);
    }

    public static void displayPost(Node root) {
        if (root == null) return;
        displayPost(root.left);
        displayPost(root.right);
        System.out.println(root);
    }
}
