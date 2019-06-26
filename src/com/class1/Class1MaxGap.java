package com.class1;

import java.util.Arrays;

public class Class1MaxGap {
    public  static  int maxGap(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int len = arr.length;
        boolean[] hasNum = new boolean[len + 1];
        int[] bmax = new int[len + 1];
        int[] bmin = new int[len + 1];
        int bid;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len, min, max);
            bmax[bid] = hasNum[bid] ? Math.max(bmax[bid], arr[i]) : arr[i];
            bmin[bid] = hasNum[bid] ? Math.min(bmin[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }

        int gap = 0;
        int lastMax = bmax[0];
        for (int i = 1; i <= arr.length; i++) {
            if(hasNum[i]){
                gap = Math.max(bmin[i] - lastMax, gap);
                lastMax = bmax[i];
            }
        }

        return gap;



    }

    public static int bucket(int num, int len, int min, int max){
        return (int) ((num - min) * len / (max - min));
    }




    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    }

    public static int[] randomArray(int maxValue, int maxLength){
        int[] arr = new int[(int) ((maxValue + 1) * Math.random())];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int) ((maxValue+1) * Math.random()) - (int) ((maxValue) * Math.random());
        }

        return arr;
    }

    public  static  int[] copyArray(int[] arr1){
        if(arr1 == null){
            return  null;
        }

        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++){
            arr2[i] = arr1[i];
        }
        return arr2;
    }

    public static int comparator(int[] arr){
        if(arr.length == 0 || arr.length < 2)
            return 0;

        Arrays.sort(arr);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            gap = Math.max(arr[i] - arr[i-1], gap);
        }
        return gap;
    }

    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static boolean isEqual(int[] arr1, int[] arr2){
        if((arr1 ==null && arr2 != null) || (arr1 != null && arr2 == null)){
            return true;
        }
        if(arr1 == null || arr2 == null){
            return true;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
           if(arr1[i] != arr2[i]){
               return false;
           }
        }
        return true;
    }

    public static void main(String[] arguments) {
        int maxValue = 100;
        int maxLength = 100;
        int times = 5000;
        boolean right = true;

//        int[] arr = {3, 1, 3, 5, 6};
//        System.out.println(comparator(arr));
//        System.out.println(bucket(98, 9, 0, 99));
        for (int i = 0; i < times; i++) {
            int[] arr1 = randomArray(maxValue, maxLength);
            int[] arr2 = copyArray(arr1);


            if (comparator(arr2) != maxGap(arr1)) {
                right = false;
                break;
            }
        }

        System.out.println(right ? "fine" : "my method is wrong");
        int[] arr = randomArray(maxValue, maxLength);
        Arrays.sort(arr);
        printArray(arr);
        System.out.println(maxGap(arr));


    }

}


