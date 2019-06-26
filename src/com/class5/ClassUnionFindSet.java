package com.class5;

import java.util.HashMap;
import java.util.List;

public class ClassUnionFindSet {
    public static class Node{
        public int value;

        public Node(int data){
            this.value = data;
        }
    }

    public static class UnionFindSet{
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> sizeMap;

        public UnionFindSet(List<Node> nodeList){
            makeSet(nodeList);
        }

        private void makeSet(List<Node> nodeList){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for(Node node : nodeList){
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }

        }

        public Node findHead(Node node){
            Node father = fatherMap.get(node);
            if(father != node){
                father = findHead(father);
            }
            return father;
        }

        public boolean isSameSet(Node a, Node b){
            return findHead(a) == findHead(b);
        }

        public void union(Node a, Node b){
            if(a == null || b == null){
                return;
            }

            Node ahead = findHead(a);
            Node bhead = findHead(b);
            if(ahead != bhead){
                int asize = sizeMap.get(ahead);
                int bsize = sizeMap.get(bhead);
                if(asize <= bsize){
                    fatherMap.put(ahead, bhead);
                    sizeMap.put(bhead, asize + bsize);
                }else {
                    fatherMap.put(bhead, ahead);
                    sizeMap.put(ahead, asize + bsize);
                }
            }
        }
    }

    public static void main(String[] args) {

    }

}
