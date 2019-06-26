package com.class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBSTAndCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST(Node head){
        if(head == null){
            return true;
        }

        int pre = Integer.MIN_VALUE;

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                if(head.value < pre){
                    return false;
                }
                pre = head.value;
                head = head.right;
            }
        }
        return true;
    }

    public static boolean isCBT(Node head){
        if(head == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node left = null;
        Node right = null;
        boolean leaf = false;
        while (!queue.isEmpty()){
            head = queue.poll();
            left = head.left;
            right = head.right;

            if(left == null && right != null){
                return false;
            }

            if(leaf && (left != null || right != null)){
                return false;
            }

            if(left == null || right == null){
                leaf = true;
            }
            if(left != null){
                queue.offer(left);
            }
            if(right != null){
                queue.offer(right);
            }
        }
        return true;

    }
    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }
}
