package org.example;

import java.util.Stack;

/**
 * This is number of connected components
 */
public class NumberOfProvinces {
    public static int getProvinces(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        int provinces = 0;
        for(int i=0; i<n; i++) {
            if(visited[i] == 1) {
                continue;
            }
            provinces++;
            stack.push(i);
            visited[i] = 1;
            while (!stack.isEmpty()) {
                int popped = stack.pop();
                for(int j=0; j<n; j++) {
                    if(isConnected[popped][j] == 1 && visited[j] !=1) {
                        stack.push(j);
                        visited[j] = 1;
                    }
                }
            }

        }
        return provinces;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(getProvinces(arr));
    }
}
