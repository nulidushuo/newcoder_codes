package com.class4;

public class CompleteTreeNodeNumber {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int mostLeftNode(Node node, int level){
        while (node != null){
            level++;
            node = node.left;
        }

        return level - 1;
    }

    public static int nodeNum(Node head){
        if(head == null){
            return 0;
        }

        return bs(head, 1, mostLeftNode(head, 1));
    }

    public static int bs(Node node, int level, int h){
        if(level == h){
            return 1;
        }

        if(mostLeftNode(node.right, level + 1) == h){
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        }else {
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }


}
