class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // maximally optimized for time
        HashSet[] rows = new HashSet[board.length];
        HashSet[] columns = new HashSet[board.length];
        HashSet[][] sections = new HashSet[board.length / 3][board.length / 3];
        
        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashSet<Integer>();
            columns[i] = new HashSet<Integer>();
        }
        
        for (int i = 0; i < board.length / 3; i++) {
            for (int j = 0; j < board.length / 3; j++) {
                sections[i][j] = new HashSet<Integer>();
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (rows[i].contains(board[i][j]) || columns[j].contains(board[i][j])) {
                        return false;
                    } else if(sections[i / 3][j / 3].contains(board[i][j])) {
                        return false;
                    }
                    rows[i].add(board[i][j]);
                    columns[j].add(board[i][j]);
                    sections[i / 3][j / 3].add(board[i][j]);
                }
            }
        }
        return true;
    }
}