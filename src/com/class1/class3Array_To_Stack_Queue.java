package com.class1;

public class class3Array_To_Stack_Queue {
//    用不到外面的实例变量和方法就用static
    public static class ArrayStack{
        private Integer[] arr;
        private Integer size;
        public ArrayStack(int intialsize){
            if(intialsize < 0){
                throw new IllegalArgumentException("stack size is less than 0");
            }
            arr = new Integer[intialsize];
            size = 0;
        }

        public void push(Integer obj){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("stack is full");
            }
            arr[size++] = obj;

        }
        public Integer pop(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("stack is empty");

            }
            return arr[--size];
        }

        public Integer peek(){
            if(size == 0){
                return null;
            }
            return arr[size - 1];
        }
    }

    public static class ArrayQueue{
        private Integer arr[];
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(Integer initialsize){
            if(initialsize < 0){
                throw new IllegalArgumentException("size is less than 0");
            }
            arr = new Integer[initialsize];
            size = 0;
            first = 0;
            last = 0;

        }

        public void push(Integer obj){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("queue is full");
            }

            arr[last] = obj;
            size++;
            last = last == arr.length -1 ? 0 : last + 1;

        }

        public Integer poll(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("queue is empty");

            }

            Integer temp = first;
            size--;
            first = first == arr.length -1? 0 : first + 1;
            return arr[temp];
        }
    }




    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(4);
        aq.push(2);
        aq.push(7);
        System.out.println(aq.poll());
        System.out.println(aq.poll());

        ArrayStack ac = new ArrayStack(4);
        ac.push(2);
        ac.push(7);
        System.out.println(ac.pop());
        System.out.println(ac.pop());

    }
}
