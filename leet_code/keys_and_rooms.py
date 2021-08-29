class Solution:
    def helper(self, rooms: List[List[int]], visited: Set[int], cur_room: int):
        if not cur_room in visited:
            visited.add(cur_room)
            for next_room in rooms[cur_room]:
                self.helper(rooms, visited, next_room)
    
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        
        # start with room 0
        # gather keys and traverse the rooms for which you have keys
        # for each room you visit, mark as visited
        # stop visiting rooms once all rooms have been visited
        # if size of visited is less than size of rooms, return false
        # else, return true
        
        # initialize set with rooms
        visited = set()
        
        self.helper(rooms, visited, 0)
        return len(visited) == len(rooms)