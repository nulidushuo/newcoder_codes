package com.class1;

public class Class3PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        while (tR <= dR && tC <= dC){
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC){
        if(tR == dR){
            int c = tC;
            while (c <= dC){
                System.out.print(matrix[tR][c++] + " ");
            }
        }else if (tC == dC){
            int r = tR;
            while (r <= dR){
                System.out.print(matrix[r++][tC] + " ");
            }
        }else {
            int c = tC;
            int r = tR;
            while (c < dC){
                System.out.print(matrix[tR][c++] + " ");
            }
            while (r < dR){
                System.out.print(matrix[r++][dC] + " ");
            }
            while (c > tC){
                System.out.print(matrix[dR][c--] + " ");
            }
            while (r > tR){
                System.out.print(matrix[r--][tC] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12}};
        spiralOrderPrint(matrix);
    }
}
