class Solution:
    
    def helper(self, nums: List[int], current: List[int], product: List[List[int]]):
        
        # base case if there are no numbers left in nums, append permutation
        if len(nums) == 0:
            new_current = []
            for i in current:
                new_current.append(i)
            product.append(new_current)

        # create all possible permutations
        for i in range(0, len(nums)):
            temp = nums[i]
            current.append(temp)
            nums.remove(temp)
            self.helper(nums, current, product)
            nums.insert(i, temp)
            current.remove(temp)
    
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        # product containing all permutations
        product = []

        # current solution
        current = []

        # recursive helper
        self.helper(nums, current, product)
        return product