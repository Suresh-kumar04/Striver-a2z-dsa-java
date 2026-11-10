package Recursion.Sudoku;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
            isValidBoard(board);
            //O(9^m) where m is the number of empty cells in the board
        }
    boolean isValidBoard(char[][] board){
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == '.'){
                    for (char k = '1'; k <='9'; k++) {
                        if(isSafe(board, i, j , k)){
                           board[i][j] = k;
                           // if the board is valid after placing the number, continue to solve the rest of the board
                           if(isValidBoard(board)) return  true;
                            board[i][j] = '.';
                        }                        
                    }
                    // no valid number found for this cell, backtrack
                    return false;
                }
            }
        }
        return true;
    }
   static  boolean isSafe(char[][] board, int i , int j , char num){
            for (int rc = 0; rc < board.length; rc++) {
                if(board[rc][j] == num){
                    return  false;
                }
                if(board[i][rc] == num){
                    return false;
            }
            }

            //small box
            int row = i - i%3;
            int col = j - j%3;
            for(int x =row ;x <row+3;x++ ) {
                for(int y = col ; y < col +3 ; y++){
                    if(board[x][y] == num) return  false;
                }
            }
        return  true;

    }
}
