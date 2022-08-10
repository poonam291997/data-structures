package org.example;

import java.util.*;

public class GraphValidTree {

    public static boolean isValidTree(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Integer> parent = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        parent.put(0,-1);
        while(!stack.isEmpty()) {
            Integer popped = stack.pop();
            List<Integer> neighbours = adjList.get(popped);
            for (Integer neighbour : neighbours) {
                if (!neighbour.equals(parent.get(popped))) {
                    if (!parent.containsKey(neighbour)) {
                        stack.push(neighbour);
                        parent.put(neighbour, popped);
                    } else {
                        return false;
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            if (!parent.containsKey(i)) {
                return false;
            }
        }
        return true;
    }
}
