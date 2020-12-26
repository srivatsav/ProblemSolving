package com.disjointset;

class DisJointSet {
    public static void main(String[] args) {

        int[] parent = new int[5];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    private static int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x], parent);
    }

    private static void union(int x, int y, int[] parent) {
        int x_rep = find(x, parent);
        int y_rep = find(y, parent);

        if (x_rep == y_rep)
            return;

        parent[y_rep] = x_rep;
    }
}