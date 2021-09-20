class Solution:
    def frequencySort(self, s: str) -> str:
        
        freq: dict[chr, int] = {}
        for char in s:
            if not char in freq:
                freq[char] = 0
            freq[char] += 1
        s = ''
        order: list = sorted(freq, key = freq.get, reverse=True)
        for val in order:
            for i in range(0, freq[val]):
                s+=val
        return s