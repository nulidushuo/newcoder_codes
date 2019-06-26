package com.class7;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {
    public static class Program{
        public int start;
        public int end;
        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class MinEndComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2){
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int cur){
        Arrays.sort(programs, new MinEndComparator());
        int res = 0;
        for (int i = 0; i < programs.length; i++) {
            if(programs[i].start > cur){
                res++;
                cur = programs[i].end;
            }
        }
        return res;
    }
}
