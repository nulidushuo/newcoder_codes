package com.class1;

public class Class1NetherlandFlags {
    public static int[] partition(int[] arr, int L, int r, int num){
        int less = L -1;
        int more = r + 1;
        int cur = L;
        while (cur < more){
            if(arr[cur] < num)
                swap(arr, cur++, ++less);
            else if(arr[cur] > num)
                swap(arr, cur, --more);
            else
                cur++;
        }
        return new int[] {less + 1, more - 1};
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
