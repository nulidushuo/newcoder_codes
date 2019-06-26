package com.class8;

public class MoneyProblem {
    public static boolean money1(int[] arr, int aim){
        return process(arr, aim, 0, 0);

    }

    public static boolean process(int[] arr, int aim, int i, int sum){
        if(i == arr.length){
            return sum == aim;
        }

        return process(arr, aim, i+1, sum) || process(arr, aim, i+1, sum+arr[i]);
    }

    public static boolean money2(int[] arr, int aim){
        boolean[][] dp = new boolean[arr.length+1][aim+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length -1; i >=0; i--) {
            for (int j = 0; j < aim; j++) {
                if(j + arr[i] <= aim){
                    dp[i][j] = dp[i+1][j] || dp[i+1][j+arr[i]];
                }else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[] arr = { 1, 4, 8 };
        int aim = 12;
        System.out.println(money1(arr, aim));
        System.out.println(money2(arr, aim));
    }
}
