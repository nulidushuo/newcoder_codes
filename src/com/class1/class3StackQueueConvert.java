package com.class1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class class3StackQueueConvert {
    public static class TwoQueuesStack{
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueuesStack(){
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(Integer pushInt){
            data.add(pushInt);
        }

        public Integer pop(){
            if(data.isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            while (data.size() > 1){
                help.add(data.poll());
            }
            Integer value = data.poll();
            swap();
            return value;
        }

        public void swap(){
            Queue<Integer> tmp = help;
            help = data;
            data = tmp;
        }

        public Integer peek(){
            if(data.isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            while (data.size() > 1){
                help.add(data.poll());
            }
            Integer value = data.peek();
            help.add(data.poll());
            swap();
            return value;
        }
    }

    public static class TwoStacksQueue{
        private Stack<Integer> push;
        private Stack<Integer> pop;

        public TwoStacksQueue(){
            push = new Stack<>();
            pop = new Stack<>();
        }

        public void push(int pushInt){
            push.add(pushInt);
        }

        public int poll(){
            if(push.isEmpty() && pop.isEmpty()){
                throw new RuntimeException("Queue is empty");
            }else if (pop.isEmpty()){
                while (!push.isEmpty()){
                    pop.add(push.pop());
                }
            }

            return pop.pop();
        }

        public int peek(){
            if(push.isEmpty() && pop.isEmpty()){
                throw new RuntimeException("Queue is empty");
            }else if (pop.isEmpty()){
                while (!push.isEmpty()){
                    pop.add(push.pop());
                }
            }

            return pop.peek();

        }

    }

    public static void main(String[] args) {
        TwoStacksQueue myqueue = new TwoStacksQueue();
        myqueue.push(1);
        myqueue.push(2);
        myqueue.push(3);
        myqueue.push(4);
        myqueue.push(5);
        System.out.println(myqueue.poll());
        System.out.println(myqueue.peek());



    }
}
