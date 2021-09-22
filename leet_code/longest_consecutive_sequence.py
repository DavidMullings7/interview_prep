class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hashed: set = set(nums)
        
        maximum: int = 0
        count: int = 0
        for val in hashed:
            if not val - 1 in hashed:
                count = 1
                i: int = 1
                while val + i in hashed:
                    count+=1
                    i+=1
                if count > maximum:
                    maximum = count
        return max(maximum, count)