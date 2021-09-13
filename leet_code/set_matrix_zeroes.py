class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        c = False
        r = False
        for i in range(0, len(matrix)):
            if matrix[i][0] == 0:
                c = True
        for j in range(0, len(matrix[0])):
            if matrix[0][j] == 0:
                r = True
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[i])):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        for i in range(1, len(matrix[0])):
            if matrix[0][i] == 0:
                for j in range(0, len(matrix)):
                    matrix[j][i] = 0
        for i in range(1, len(matrix)):
            if matrix[i][0] == 0:
                for j in range(0, len(matrix[0])):
                    matrix[i][j] = 0
        if c:
            for i in range(0, len(matrix)):
                matrix[i][0] = 0
        if r:
            for i in range(0, len(matrix[0])):
                matrix[0][i] = 0
        return matrix
        
        