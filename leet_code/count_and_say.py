class Solution:
    
    def helper(self, n: int, curr: int, current: str):
        
        # base case
        if curr == n:
            return current
        
        # recurse over solution space
        i = 0
        new_current = ''
        while i < len(current):
            count = 0
            j = i
            cur_char = current[j]
            while j < len(current) and current[j] == cur_char:
                count+=1
                j+=1
            new_current += (str(count) + cur_char)
            i = j
        return self.helper(n, curr + 1, new_current)
        
    def countAndSay(self, n: int) -> str:
        
        # recursive helper
        return self.helper(n, 1, '1')