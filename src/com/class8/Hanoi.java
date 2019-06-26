package com.class8;

public class Hanoi {
    public static void process(int N, String from, String to, String help){
        if(N == 1){
            System.out.println("Move 1" + " from " + from + " to " + to);
        }else {
            process(N-1, from, help, to);
            System.out.println("Move " + N + " from " + from + "to" + to);
            process(N-1, help, to, from);
        }
    }

    public static void main(String[] args) {
        process(3, "zuo", "you", "zhong");
    }
}
