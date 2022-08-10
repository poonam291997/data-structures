package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfConnectedComponents {

    public static int getNumberOfConnectedComp(int n, int[][] edges) {

        int components = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            components++;
            stack.push(i);
            visited[i] = 1;
            while (!stack.isEmpty()) {
                Integer popped = stack.pop();
                List<Integer> neighbours = adjList.get(popped);
                for (Integer neighbor : neighbours) {
                    if (visited[neighbor] != 1) {
                        stack.push(neighbor);
                        visited[neighbor] = 1;
                    }
                }
            }
        }
        return components;
    }
}
