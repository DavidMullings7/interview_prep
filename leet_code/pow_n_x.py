class Solution:
    def helper(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n == 1:
            return x
        if n % 2 == 0:
            return self.helper(x * x, n / 2)
        
        x = x * self.helper(x, n - 1)
        return x
            
    def myPow(self, x: float, n: int) -> float:
        # count = abs(n)
        # result = 1
        # while (count > 0):
        #     result = result * x
        #     count-=1
        # if n > 0:
        #     return result
        # else:
        #     return 1 / result
        exp : int = self.helper(x, abs(n))
        if (n > 0):
            return exp
        else:
            return 1 / exp