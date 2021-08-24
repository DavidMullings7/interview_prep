
import java.util.*;

class Solution {
    
    public boolean exist(char[][] board, String word) {
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, set, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean helper(char[][] board, String word, HashSet<String> set, int x, int y) {
        String temp = x + "," + y;
        if ((x < 0) || (y < 0) || (x > board.length - 1) || y > (board[0].length - 1)) {
            return false;
        } else if (set.contains(temp)) {
            return false;
        } else if (word.charAt(0) != board[x][y]) {
            return false;
        } else if (word.length() == 1) {
            return true;
        }
        
        set.add(temp);
        if (helper(board, word.substring(0 + 1), set, x + 1, y))
            return true;
        if (helper(board, word.substring(0 + 1), set, x - 1, y))
            return true;
        if (helper(board, word.substring(0 + 1), set, x, y + 1))
            return true;
        if (helper(board, word.substring(0 + 1), set, x, y - 1))
            return true;
        set.remove(temp);
        return false;
    }
}