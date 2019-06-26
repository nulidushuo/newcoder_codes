package com.class1;

public class Class3SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if(head == null){
            return head;
        }

        int i = 0;
        Node cur = head;
        while (cur != null){
            i++;
            cur = cur.next;
        }

        Node[] arrNodes = new Node[i];
        cur = head;

        for(i = 0; i < arrNodes.length; i++){
            arrNodes[i] = cur;
            cur = cur.next;
        }

        arrPartition(arrNodes, pivot);
        for (i = 0; i < arrNodes.length - 1; i++){
            arrNodes[i].next = arrNodes[i+1];
        }
        arrNodes[i].next = null;

        return arrNodes[0];
    }

    public static void arrPartition(Node[] arrNodes, int pivot){
        int less = -1;
        int more = arrNodes.length;
        int cur = 0;

        while (cur < more){
            if(arrNodes[cur].value < pivot){
                swap(arrNodes, cur++, ++less);
            }else if (arrNodes[cur].value > pivot){
                swap(arrNodes, cur, --more);
            }else {
                cur++;
            }
        }
    }

    public static void swap(Node[] arrNodes, int i, int j){
        Node tmp = arrNodes[i];
        arrNodes[i] = arrNodes[j];
        arrNodes[j] = tmp;
    }



    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;

        while (head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if (head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if(bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        if (eT != null) {
            eT.next = bH;
        }

        return sH != null ? sH : eH != null ? eH : bH;
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
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition1(head1, 4);
//        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }


}
