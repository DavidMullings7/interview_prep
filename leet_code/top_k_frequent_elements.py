class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq: dict[int, int] = {}
        for i in nums:
            if not i in freq:
                freq[i] = 0
            freq[i]+=1
        nums = sorted(freq, key=freq.get, reverse=True)
        return nums[0:k]
            