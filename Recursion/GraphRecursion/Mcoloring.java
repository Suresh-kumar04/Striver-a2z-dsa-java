package Recursion.GraphRecursion;

import java.util.ArrayList;
import java.util.List;

public class Mcoloring {

    boolean graphColoring(int[][] edges, int m, int n) {
        //turn the edges into adjacency list cuz it's more efficient for graph traversal because we can directly access the neighbors of a node without having to iterate through all edges
        // O(m^n * degree) where degree is the average number of neighbors for each node in the graph. The degree can be at most n-1 in a complete graph, so the worst-case time complexity is O(m^n * n).

         List<List<Integer>> adj = new ArrayList<>();
         for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
         
          for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] colors = new int[n];
        return solve(adj , colors , m , n , 0);

    }
    static boolean solve(List<List<Integer>> adj , int[] colors ,int m ,int n , int currNode){
        if( currNode == n) return true;
        for(int color=1;color<=m ;color++){
            if(isSafe(currNode ,  color , adj , colors )){
                colors[currNode] = color;
                if(solve(adj,colors,m,n,currNode+1)) return true;
                colors[currNode] = 0;
            }

        }
        return false;
    }
    static boolean isSafe(int currNode , int color ,   List<List<Integer>> adj , int[] colors){
        for(int neigh : adj.get(currNode)){
            if(colors[neigh] == color) return false;
        }
        return true;
    }
}
