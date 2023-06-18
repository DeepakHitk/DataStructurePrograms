package BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class LargestBST_Subtree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static class LargestBSTDataSet{
        int min;
        int max;
        int size;
        boolean isBST;

        public LargestBSTDataSet(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }

    public static int largestSizeBST = 0;
    public static String output = "";
    public static LargestBSTDataSet largestBST(Node root){

        if(root == null){
            return new LargestBSTDataSet(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        LargestBSTDataSet leftData = largestBST(root.left);
        LargestBSTDataSet rightData = largestBST(root.right);

        boolean isBST = false;
        int min = Math.min(leftData.min, root.data);
        int max = Math.max(rightData.max, root.data);
        int size = leftData.size + rightData.size + 1;

        if(root.data >= leftData.max && root.data <= rightData.min && leftData.isBST && rightData.isBST){
            isBST = true;
            if(size > largestSizeBST){
                largestSizeBST = size;
                output = String.valueOf(root.data) + "@" + String.valueOf(size);
            }
        }
        return new LargestBSTDataSet(min, max, size, isBST);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        // write your code here
        largestBST(root);
        System.out.println(output);
    }

}
