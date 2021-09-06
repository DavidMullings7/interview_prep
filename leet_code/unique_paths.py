class Solution:
        
    def uniquePaths(self, m: int, n: int) -> int:
        count: List[List[int]] = [] 
        for i in range(0, m):
            count.append([])
            for j in range(0, n):
                count[i].append(0)
        for i in range(0, m):
            count[i][0] = 1
        for j in range(0, n):
            count[0][j] = 1
        for i in range (1, m):
            for j in range(1, n):
                count[i][j] = count[i - 1][j] + count[i][j - 1];
        return count[m - 1][n - 1]