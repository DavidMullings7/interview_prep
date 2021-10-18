class Solution:
    
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        elif len(nums) == 1:
            return nums[0]
        
        dynamic: list[int] = []
        dynamic.append(nums[0])
        dynamic.append(max(nums[0], nums[1]))
        
        for i in range(2, len(nums)):
            dynamic.append(max(dynamic[i - 2] + nums[i], dynamic[i - 1]))
         
        return dynamic[len(nums) - 1]