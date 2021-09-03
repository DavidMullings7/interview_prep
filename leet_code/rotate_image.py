class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # first flip the matrix column-wise
        for column in range(0, len(matrix)):
            for row in range(0, len(matrix) // 2):
                temp = matrix[row][column]
                matrix[row][column] = matrix[(len(matrix) - 1) - row][column]
                matrix[(len(matrix) - 1) - row][column] = temp
                
        # transpose the matrix
        for column in range(0, len(matrix)):
            temp_col = column
            temp_row = 0
            while (temp_col < len(matrix) and temp_row < len(matrix)):
                temp = matrix[temp_row][temp_col]
                matrix[temp_row][temp_col] = matrix[temp_col][temp_row]
                matrix[temp_col][temp_row] = temp
                temp_col += 1
                temp_row += 1
        
        return matrix