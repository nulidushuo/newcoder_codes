package com.class4;

import com.sun.jdi.event.StepEvent;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serialByPre(Node head){
        if(head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);

        return res;
    }

    public static Node reconByPreString(String res){
        String[] nodes = res.split("!");
        Queue<String> nodeQueue = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            nodeQueue.offer(nodes[i]);
        }

        return reconByPreQueue(nodeQueue);
    }

    public static Node reconByPreQueue(Queue<String> nodeQueue){

        String res = nodeQueue.poll();
        Node node = null;
        if(res.equals("#")){
            node = null;
        }else {
            node = new Node(Integer.valueOf(res));
            node.left = reconByPreQueue(nodeQueue);
            node.right = reconByPreQueue(nodeQueue);
        }

        return node;
    }

    public static String serialByLevel(Node head) {
        if(head == null){
            return "#!";
        }

        Queue<Node> queue = new LinkedList<>();
        String res = head.value + "!";
        queue.offer(head);
        while (!queue.isEmpty()){
             head = queue.poll();
             if(head.left == null){
                 res += "#!";
             }else {
                 res += head.left.value + "!";
                 queue.offer(head.left);
             }
             if(head.right ==null){
                 res += "#!";
             }else {
                 res += head.right.value + "!";
                 queue.offer(head.right);
             }

        }
        return res;
    }

    public static Node reconByLevelString(String levelStr){
        String[] nodestr = levelStr.split("!");
        int i = 0;
        Node head = generateNodeByString(nodestr[i++]);

        Queue<Node> queue = new LinkedList<>();
        if(head == null){
            return null;
        }
        queue.offer(head);
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(nodestr[i++]);
            node.right = generateNodeByString(nodestr[i++]);

            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }

        return head;
    }

    public static Node generateNodeByString(String str){

        if(str.equals("#")){
            return null;
        }else {
            return new Node(Integer.valueOf(str));
        }

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
        Node head = null;
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

    }

}
