package com.class1;

import java.util.Stack;

public class Class3GetMinStack {
    public static class MyStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack(){
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public Integer getMin(){
            if(stackMin.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return stackMin.peek();
        }

        public void push(Integer obj){
            stackData.push(obj);
            if(stackMin.isEmpty()){
                stackMin.push(obj);
            }else if(obj < stackMin.peek()){
                stackMin.push(obj);
            }else{
                Integer value = stackMin.peek();
                stackMin.push(value);
            }
        }

        public Integer pop(){
            if(stackData.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            stackMin.pop();
            return stackData.pop();
        }
    }

    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());
    }
}
