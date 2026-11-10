package Recursion.Grid_problems.RatInMaze;

import java.util.ArrayList;
import java.util.List;

public class optimal {
    private final static int[] dx = {1,0,0,-1};
    private final static  int[] dy = {0,-1,1,0};
    private final static  char[] dir ={'D' ,'L','R','U'};

    public static void main(String[] args) {
        // Time: O(n^2 * 3^(n^2)) upper bound (3^(n^2) search states + O(n^2) copy per path found)
        // Auxiliary space: O(n^2) (recursion stack + StringBuilder)
        // Output space: O(P * n^2), where P = number of valid paths

        
        // Better by a constant factor: it checks bounds/wall/visited BEFORE recursing,
        // so it never makes calls that would return immediately.
        // Big-O is unchanged: O(n^2 * 3^(n^2)).
        optimal rm = new optimal();
        int[][] grid = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};
        List<String> out = rm.findPath(grid);
        System.out.println(out);
    }

    public List<String> findPath(int[][] grid) {
        int n = grid.length;
        List<String> res = new ArrayList<>();
        backtrack(grid , n , res , new StringBuilder() ,0,0);
        return res;

    }

    private void backtrack(int[][] grid, int n, List<String> res, StringBuilder path, int i, int j) {
        if(i== n-1 && j == n-1){
            res.add(path.toString());
            return;
        }
        grid[i][j] = 0; // visited
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if(ni >=0 && nj>=0 && ni < n && nj <n && grid[ni][nj] ==1){
                path.append(dir[k]);
                backtrack(grid, n, res, path, ni, nj);
                path.deleteCharAt(path.length()-1);
            }
        }
        grid[i][j] = 1;
        
    }
}
