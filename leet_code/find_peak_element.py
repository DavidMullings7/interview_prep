class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        if len(nums) == 0: return None
        prev_int: int = (-2)**31 - 1
        for i in range(0, len(nums) - 1):
            if prev_int < nums[i] and nums[i + 1] < nums[i]:
                return i
            else:
                prev_int = nums[i]
        if prev_int < nums[len(nums) - 1]:
            return len(nums) - 1