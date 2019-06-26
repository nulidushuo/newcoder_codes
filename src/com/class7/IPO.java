package com.class7;

import java.nio.channels.Pipe;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static class Node{
        public int c;
        public int p;

        public Node(int c, int p){
            this.c = c;
            this.p = p;
        }
    }

    public static class MinCostComperator implements Comparator<Node>{

        @Override
        public int compare(Node a, Node b){
            return a.c - b.c;
        }
    }

    public static class MaxProComperator implements Comparator<Node>{
        @Override
        public int compare(Node a, Node b){
            return b.p - a.p;
        }
    }

    public static int findMaxProfit(int W, int k, int[] costs, int[] profits){
        Node[] project = new Node[costs.length];
        for (int i = 0; i < costs.length; i++) {
            project[i] = new Node(costs[i], profits[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComperator());
        PriorityQueue<Node> maxProQ = new PriorityQueue<>(new MaxProComperator());
        for (int i = 0; i < project.length; i++) {
            minCostQ.add(project[i]);
        }

        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c < W){
                maxProQ.add(minCostQ.poll());
            }

            if(maxProQ.isEmpty()){
                return W;
            }
            W += maxProQ.poll().p;
        }

        return W;

    }
}
