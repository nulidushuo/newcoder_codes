package com.class4;

public class IsBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnData{
        public int height;
        public boolean isB;

        public ReturnData(int h, boolean is){
            this.height = h;
            this.isB = is;
        }
    }

    public static ReturnData process(Node head){
        if(head == null){
            return new ReturnData(0, true);
        }

        ReturnData left = process(head.left);
        if(!left.isB){
            return new ReturnData(0, false);
        }

        ReturnData right = process(head.right);
        if(!right.isB){
            return new ReturnData(0, false);
        }

        if(Math.abs(left.height - right.height) > 1){
            return new ReturnData(0, false);
        }

        return new ReturnData(Math.max(left.height, right.height) + 1, true);
    }

    public static boolean isBalance(Node head){
        ReturnData data = process(head);
        return data.isB;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }

}
