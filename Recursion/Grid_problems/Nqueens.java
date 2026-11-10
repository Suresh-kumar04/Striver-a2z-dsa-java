package Recursion.Grid_problems;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {

    List<List<String>> res ;
    public static void main(String[] args) {

        Nqueens nq = new Nqueens();
        List<List<String>> out = nq.solveNQueens(4);
        // System.out.println(out);
    }

    public List<List<String>> solveNQueens(int n) {
     res = new ArrayList<>();
      boolean[][] board = new boolean[n][n];
      solve(board , 0);
      return res;
    }

    void solve(boolean[][] board , int rows){
        if(rows == board.length){
            res.add(build(board));
            printAsBoard(board);
            return;
        }
        for(int col =0;col < board[0].length ;col++){
            if(isSafe(board , rows , col)){
                board[rows][col] = true;
                solve(board , rows+1);
                board[rows][col] = false;
            }
        }

    }

    boolean isSafe(boolean[][] board , int r , int c){
       //row scan is not needed as we are placing one queen per row
        //col
        for(int row = 0;row<r;row++){
            if(board[row][c]) return false;
        }
        //top right diagonal
        int rr = r-1;
        int rc = c+1;
        while(rr >=0 && rc <board[0].length){
            if(board[rr][rc]) return false;
            rr--;
            rc++;
        }

        //top left diagonal
        int lr = r-1;
        int lc = c-1;
        while(lr >=0 && lc >=0){
            if(board[lr][lc]) return false;
            lr--;
            lc--;
        }

        //no need for bottom left and bottom right diagonal as we are placing one queen per row and we are checking only the rows above the current row
        return true;
    }
    List<String> build(boolean[][] board){
        List<String> out = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<board[0].length;j++){
                sb.append(board[i][j] ? 'Q' : '.');
            }
            out.add(sb.toString());
        }
        return out;
    }

    void printAsBoard(boolean[][] board){
        for(List<String> li : res){
            for(String val : li){
                System.out.println(val);
            }
            System.out.println();
        }
    }
}
