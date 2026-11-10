package Recursion.Grid_problems.RatInMaze;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        // Time: O(n^2 * 3^(n^2)) upper bound (3^(n^2) search states + O(n^2) copy per path found)
        // Auxiliary space: O(n^2) (recursion stack + StringBuilder)
        // Output space: O(P * n^2), where P = number of valid paths
        RatInMaze rm = new RatInMaze();
        int[][] grid = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};
        List<String> out = rm.findPath(grid);
        System.out.println(out);
    }
    
    public List<String> findPath(int[][] grid) {
        
        List<String> res = new ArrayList<>();
        int n = grid.length;
        if (n == 0 || grid[0][0] != 1 || grid[n-1][n-1] != 1) {
            return res;
        }
        backtrack(grid , n , res , new StringBuilder() ,0,0);
        return res;

    }
    void backtrack(int[][] grid , int n , List<String> res , StringBuilder curr,
    int i , int j){
        if(i<0 || j<0 || i >=n || j>= n) return;
        if(grid[i][j] != 1) return;
        if(i == n-1&& j ==n-1 ){
            res.add(curr.toString());
            return;
        }

        int temp = grid[i][j];
        grid[i][j] = 2;

        curr.append('D');
        backtrack(grid , n , res , curr , i+1 , j);
        curr.deleteCharAt(curr.length()-1); 

        curr.append('U');
        backtrack(grid , n , res , curr , i-1 , j);
        curr.deleteCharAt(curr.length()-1);
        
        curr.append('R');
        backtrack(grid , n , res , curr , i , j+1);
        curr.deleteCharAt(curr.length()-1);

        curr.append('L');
        backtrack(grid , n , res , curr , i , j-1);
        curr.deleteCharAt(curr.length()-1);

        grid[i][j] = temp;
    }
}

