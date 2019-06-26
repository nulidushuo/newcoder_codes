package com.class8;

import java.util.Map;

public class MinPath {
    public static int minPath1(int[][] m){
        return walk(m, 0, 0);
    }
    public static int walk(int[][] m, int i, int j){
        if(i == m.length - 1 && j == m[0].length - 1){
            return m[i][j];
        }
        if(i == m.length - 1){
            return m[i][j] + walk(m, i, j+1);
        }
        if(j== m[0].length -1){
            return m[i][j] + walk(m, i+1, j);
        }
        int right  = m[i][j] + walk(m, i, j+1);
        int down = m[i][j] + walk(m, i+1, j);
        return Math.min(right, down);
    }

    public static int minPath2(int[][] m){
        if(m == null || m.length == 0 || m[0] == null || m[0].length == 0){
            return 0;
        }
        int M = m.length;
        int N = m[0].length;
        int[][] dp = new int[M][N];
        dp[M - 1][N-1] = m[M -1][N-1];
        for (int i = M - 2; i > -1; i--) {
            dp[i][N-1] = m[i][N-1] + dp[i +1][N-1];
        }
        for (int j = N-2; j > -1; j--) {
            dp[M-1][j] = m[M-1][j] + dp[M-1][j+1];
        }
        for (int i = M -2; i > -1; i--) {
            for (int j = N-2; j >-1; j--) {
                dp[i][j] = m[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];

    }
    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }

}
