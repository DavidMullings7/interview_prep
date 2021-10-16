class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix or k < 1: return
        s = set()
        s.add((0, 0))
        heap = [(matrix[0][0], 0, 0)]
        while k > 1:
            top = heapq.heappop(heap)
            row, col = top[1], top[2]
            if col+1 < len(matrix[0]) and (row, col+1) not in s:
                heapq.heappush(heap, (matrix[row][col+1], row, col+1))
                s.add((row, col+1))
            if row+1 < len(matrix) and (row+1, col) not in s:
                heapq.heappush(heap, (matrix[row+1][col], row+1, col))
                s.add((row+1, col))
            k -= 1
            
        return heap[0][0]