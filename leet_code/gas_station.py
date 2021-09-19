class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        # for i in range(0, len(gas)):
        #     stops: int = 0
        #     tank: int = 0
        #     while stops < len(gas):
        #         if tank + gas[(i + stops) % len(gas)] >= cost[(i + stops) % len(gas)]:
        #             tank += gas[(i + stops) % len(gas)] - cost[(i + stops) % len(gas)]
        #             stops+=1
        #         else:
        #             break
        #     if stops == len(gas):
        #         return i
        # return -1
    
        start, tank, total = 0, 0, 0
        for idx in range(len(cost)):
            tank += gas[idx] - cost[idx]
            if tank < 0:
                start = idx + 1
                total += tank
                tank = 0

        if total + tank < 0:
            return -1
        else:
            return start