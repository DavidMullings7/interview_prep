class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        # array of indeces that have already been visited
        visited: List[List[bool]] = []
        for i in range(0, len(matrix)):
            visited.append([])
            for j in range(0, len(matrix[0])):
                visited[i].append(False)
                
        # pattern of spiral addition (right, down, left, up)
        pattern: List[List[int]] = [[0, 1], [1, 0], [0, -1], [-1, 0]]
            
        # how many visited indeces have been found consecutively (2 means that iteration is 
        # complete)
        cur_visited: int = 0
        
        # product list to be returned
        result: List[int] = []
            
        # current type of spiral addition
        switcher: int = 0
            
        # current index 
        i = 0
        j = 0
        
        # iterator 
        while(cur_visited < 2):
            if (i == len(matrix) or j == len(matrix[0]) or visited[i][j]):
                i -= pattern[switcher % 4][0]
                j -= pattern[switcher % 4][1]
                switcher+= 1
                i += pattern[switcher % 4][0]
                j += pattern[switcher % 4][1]
                cur_visited += 1
            else:
                cur_visited = 0
                visited[i][j] = True
                result.append(matrix[i][j])
                i += pattern[switcher % 4][0]
                j += pattern[switcher % 4][1]
                
        return result