package Recursion.Grid_problems;
public class WordSearch {
     public boolean exist(char[][] board, String word) {
        //prune 1
        if(word.length() > board.length * board[0].length) return  false;

        //prune 2
        int[] count = new int[128];
        for(char[] row : board){
            for(char ch : row){
                count[ch] ++;
            }
        }
        for(char ch : word.toCharArray()){
            if(--count[ch] <0) return false;
        }

        char firstWord = word.charAt(0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == firstWord){
                   if( backtrack(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
     }
     boolean backtrack(char[][] board , String word , int i , int j , int wordIndex){
        if(wordIndex == word.length()){
            return true;
        }

        if(i >=board.length || j<0 || i <0 || j >=board[0].length){
            return false;
        }

        if(word.charAt(wordIndex) != board[i][j]) return  false;

        char temp = board[i][j];
        board[i][j] = '~';
        boolean found = backtrack(board, word, i+1, j, wordIndex+1) ||
                        backtrack(board, word, i, j+1, wordIndex+1) ||
                        backtrack(board, word, i-1, j, wordIndex+1) ||
                        backtrack(board, word, i, j-1, wordIndex+1);
        board[i][j] = temp;
        
        return found;

     }
}
