class Solution:
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        length = pow(2, len(nums))
        
        result: List[List[int]] = []
        for i in range(length):
            s: List[int] = []
            for j in range(len(nums)):
                if i & (1<<j):
                    s.append(nums[j])
            result.append(s)
        return result
                    