package com.class7;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexcography {

    public static class MyComparator implements Comparator<String>{
        public int compare(String a, String b){
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }

        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (String str : strs){
            res += str;
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));
        String a = "a";
        String b = "b";
        System.out.println(b.compareTo(a));

    }

}
