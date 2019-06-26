package com.class8;

public class PrintAllSubsequences {
    public static void printAllSub(char[] chs, int i, String res){
        if(i == chs.length){
            System.out.println(res);
            return;
        }
        printAllSub(chs, i+1, res);
        printAllSub(chs, i+1, res + String.valueOf(chs[i]));
    }

    public static void main(String[] args) {
        String str = "abc";
        printAllSub(str.toCharArray(), 0, "");
    }
}
