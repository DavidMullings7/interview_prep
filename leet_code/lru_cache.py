class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.time = 0
        self.dictionary: dict = {}

    def get(self, key: int) -> int:
        self.time+=1
        if key in self.dictionary:
            self.dictionary[key] = (self.dictionary[key][0], self.time)
            return self.dictionary[key][0]
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        self.time+=1
        if key in self.dictionary:
            self.dictionary[key] = (value, self.time)
            return self.dictionary[key][0]
        elif len(self.dictionary) == self.capacity:
            lru: int = None
            lru_time: int = 2 * 10**5
            for i in self.dictionary:
                if self.dictionary[i][1] < lru_time:
                    lru_time = self.dictionary[i][1]
                    lru = i
            self.dictionary.pop(lru)
            self.dictionary[key] = (value, self.time)
        else:
            self.dictionary[key] = (value, self.time)

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)