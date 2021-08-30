class Solution:
    
    def helper(self, graph: List[List[int]], i: int, current: List[int], product: List[List[int]]):
        
        # if at last node, return path
        if (i == len(graph) - 1):
            temp = []
            for val in current:
                temp.append(val)
            temp.append(i)
            product.append(temp)
            temp = None

        # recurse over all possible paths
        else:
            current.append(i)
            for node in graph[i]:
                self.helper(graph, node, current, product)
            current.remove(i)
            
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        # initialize all paths list
        product = []

        # current nodes in path
        current = []

        # recursive helper
        self.helper(graph, 0, current, product)
        return product