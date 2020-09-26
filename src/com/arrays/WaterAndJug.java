package com.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterAndJug {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(3, 5, 4));
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        if (z < 0 || z > x + y) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int[] options = new int[] { x, y, -x, -y };

        /**
         * options = {3,5,-3,-5}
         * 
         * visited = {3,5} size = 2 q = {5}
         * 
         * 0 -> {0+3, 0+5, 0-3, 0-5}
         * 
         * z = 0
         * 
         * J1 -> 3 J2 -> 0
         * 
         * j1 -> 3, j2 -> 0
         * 
         * 3+5, 3-3, 3-5,
         * 
         * 3 -> {3+3, 3+5, 3-3, 3-5}
         * 
         */
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                int cur = queue.poll();
                if (cur == z) {
                    return true;
                }
                for (int o : options) {
                    int next = cur + o;
                    if (next < 0 || next > x + y) {
                        continue;
                    }
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return false;
    }
}
