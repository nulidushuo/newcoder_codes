package com.class1;

import java.util.Stack;

public class Class3IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // need n extra space
    public static boolean isPalindrome1(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        Stack<Node> mystack = new Stack<>();
        Node cur = head;
        while (cur != null){
            mystack.push(cur);
            cur = cur.next;
        }

        while (head != null){
            if(head.value != mystack.pop().value)
                return false;
            head = head.next;
        }
        return true;

    }

    // need n/2 extra space
    public static boolean isPalindrome2(Node head) {
        if(head == null || head.next == null){
            return true;
        }

        Node fast = head;
        Node slow = head.next;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Stack<Node> mystack = new Stack<>();
        while (slow != null){
            mystack.push(slow);
            slow = slow.next;
        }

        while (!mystack.isEmpty()){
            if(mystack.pop().value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;

    }

    // need O(1) extra space
    public static boolean isPalindrome3(Node head) {
        if(head == null || head.next == null){
            return true;
        }

        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node pre = null;
        Node next = null;
        while (slow != null){
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        boolean res = true;
        slow = pre;//slow -> save last node
        while (head != null && pre != null){
            if(head.value != pre.value){
                res = false;
                break;
            }
            head = head.next;
            pre = pre.next;
        }

        pre = null;
        while (slow != null){
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        return res;

    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }


}
