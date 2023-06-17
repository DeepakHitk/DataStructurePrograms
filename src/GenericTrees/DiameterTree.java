package GenericTrees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class DiameterTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    private static int diameter;
    public static int returnHeightWithDiameterCheck(Node node){
        //Base condition
        if(node.children.size() == 0){
            return 0;
        }

        int firstGreaterChildHeight = 0;
        int secondGreaterChildHeight = 0;
        for (Node child : node.children){
            int height = returnHeightWithDiameterCheck(child);
            if(height > firstGreaterChildHeight){
                secondGreaterChildHeight = firstGreaterChildHeight;
                firstGreaterChildHeight = height;

            } else if (height > secondGreaterChildHeight) {
                secondGreaterChildHeight = height;
            }
        }


        int currentDia = firstGreaterChildHeight + secondGreaterChildHeight + 2;
        if(currentDia > diameter){
            diameter = currentDia;
        }
        return firstGreaterChildHeight +  1;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here
        diameter = 0;
        returnHeightWithDiameterCheck(root);
        System.out.println(diameter);
    }

}