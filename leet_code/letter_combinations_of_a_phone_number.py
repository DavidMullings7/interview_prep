class Solution:
    
    def helper(self, product: List[str], current: str, index: int, digits: str, letters):
        
        # if constructed full solution, add it to solutions list
        if (index == len(digits)):
            product.append(current)
        
        # recurse over options
        else:
            for digit in self.options(digits[index], letters):
                self.helper(product, current + digit, index + 1, digits, letters)
    
    # helper that returns proper list of letters based on letters map
    def options(self, digit: str, letters) -> List[str]:
        return letters[digit]
    
    def letterCombinations(self, digits: str) -> List[str]:
        
        # maps input numbers to their letter lists
        letters = {'1' : [''], '2' : ['a', 'b', 'c'], '3' : ['d', 'e', 'f'], 
               '4' : ['g', 'h', 'i'], '5' : ['j', 'k', 'l'], '6' : ['m', 'n', 'o'],
               '7' : ['p', 'q', 'r', 's'], '8' : ['t', 'u', 'v'], '9' : ['w', 'x', 'y', 'z'],
               '0' : [' ']}
        
        # check corner-case of no digits
        if (len(digits) == 0):
            return []
        
        # recursive helper and return product
        product = []
        self.helper(product, '', 0, digits, letters)
        
        return product