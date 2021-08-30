class Solution:
    def helper(self, n: int, product: List[str], current: str, opened: int, closed: int):
        
        # if closed and opened are equal to the number of pairs, add solution to list
        if opened == n and closed == n:
            product.append(current)
        
        # if number of opened parenthesis is less than the number of pairs, add an opened               # parentheis
        if opened < n:
            self.helper(n, product, current + "(", opened + 1, closed)
            
        # if number of closed parenthesis is less than the number of open parenthesis, 
        # add a closed parenthesis 
        if closed < opened:
            self.helper(n, product, current + ")", opened, closed + 1)
        
        
    
    def generateParenthesis(self, n: int) -> List[str]:
        
        # list of solutions
        product = []
        
        # recursive helper
        self.helper(n, product, "", 0, 0)
        
        return product