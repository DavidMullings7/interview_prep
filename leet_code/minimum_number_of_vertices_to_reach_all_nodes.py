class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        
        # step one: find all nodes with no incoming edges
        # return
        
        found = set()
        for edge in edges:
            found.add(edge[1])
        vertices = []
        for i in range(0, n):
            if not i in found:
                vertices.append(i)
        return vertices