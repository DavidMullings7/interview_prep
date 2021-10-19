class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        
        2 - 1:0
        3 - 0:1
        """
        
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                live_neighbors = 0
                dead_neighbors = 0
                for k in range(-1, 2):
                    for l in range(-1, 2):
                        if 0 <= i + k < len(board) and 0 <= j + l < len(board[0]) and not (k == 0 and l == 0):
                            if board[i + k][j + l] == 1 or board[i + k][j + l] == 2:
                                live_neighbors+=1
                            else:
                                dead_neighbors+=1
                if board[i][j] == 1 or board[i][j] == 2:
                    if live_neighbors < 2 or live_neighbors > 3:
                        board[i][j] = 2
                elif live_neighbors == 3:
                    board[i][j] = 3
                    
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1