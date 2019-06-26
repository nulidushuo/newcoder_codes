package com.class8;

public class Factorial {

    public static long getFactorial1(int i){
        if(i == 1){
            return 1;
        }
        return (long) i * getFactorial1(i -1);
    }

    public static long getFactorial2(int i){
        long res = 1;
        for (int j = 1; j <= i; j++) {
            res *= j;
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(getFactorial1(n));
        System.out.println(getFactorial2(n));
    }
}
