def isPowerOfTwoHelper(n: int) -> bool:
        
        if (n == 1):
            return True
        elif (n % 2 != 0):
            return False
        else:
            return isPowerOfTwoHelper(n // 2)

class Solution:
        
    def isPowerOfTwo(self, n: int) -> bool:
        if (n == 0):
            return False
        return isPowerOfTwoHelper(n)