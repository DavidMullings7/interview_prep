class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        prev: int = prices[0]
        last: int = 0
        current: int = 0
        total: int = 0
        for i in range(1, len(prices)):
            if prices[i] < prev:
                if current > last:
                    total+=prices[current] - prices[last]
                last = i
                current = i
            else:
                current = i
            prev = prices[i]
        return total + max(0, prices[current] - prices[last])