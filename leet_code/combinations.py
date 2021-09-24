class Solution:
    
    def helper(self, k: int, current: list, result: list, limit: int, curr: int):
        if k == 0 and len(current) > 0:
            result.append(list(current))
        else:
            for i in range(curr, limit + 1):
                current.append(i)
                self.helper(k - 1, current, result, limit, i + 1)
                current.pop()
                
    
    def combine(self, n: int, k: int) -> List[List[int]]:
        result: list = []
        current: list = []
        self.helper(k, current, result, n, 1)
        return result
        