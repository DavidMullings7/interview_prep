class Solution:
    
    def isPal(self, s:str) -> bool:
        i: int = 0
        while i < len(s) / 2:
            if s[i] != s[(len(s) - 1) - i]:
                return False
            i+=1
        return True
    
    def helper(self, index: int, string: str, temp_list: list[str], result: list[list[str]]):
        if index == len(string):
            result.append(list(temp_list))
        else:
            for i in range(index + 1, len(string) + 1):
                temp: str = string[index:i]
                if self.isPal(temp):
                    temp_list.append(temp)
                    self.helper(i, string, temp_list, result)
                    temp_list.pop()
    
    def partition(self, s: str) -> List[List[str]]:
        temp_list: list[str] = []
        result: list[list[str]] = []
        self.helper(0, s, temp_list, result)
        return result