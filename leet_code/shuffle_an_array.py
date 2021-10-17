import random as rd

class Solution:

    def __init__(self, nums: list[int]):
        self.nums = nums

    def reset(self) -> list[int]:
        return self.nums

    def shuffle(self) -> list[int]:
        return_list: list[int] = []
        index_list: list[int] = [i for i in range(0, len(self.nums))]
        while (len(index_list) != 0):
            rand: int = rd.randint(0, len(index_list) - 1)
            return_list.append(self.nums[index_list[rand]])
            index_list.pop(rand)
        return return_list


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()