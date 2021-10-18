class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        
        grid_copy: list[list[int]] = [[0 for i in range(0, len(grid[0]))] for j in range(0, len(grid))]
        grid_copy[0][0] = grid[0][0]
        for col in range(1, len(grid[0])):
            grid_copy[0][col] = grid_copy[0][col - 1] + grid[0][col]
        for row in range(1, len(grid)):
            grid_copy[row][0] = grid_copy[row - 1][0] + grid[row][0]
        
        for i in range(1, len(grid)):
            for j in range(1, len(grid[0])):
                grid_copy[i][j] = min(grid_copy[i][j - 1], grid_copy[i - 1][j]) + grid[i][j]
        return grid_copy[len(grid) - 1][len(grid[0]) - 1]