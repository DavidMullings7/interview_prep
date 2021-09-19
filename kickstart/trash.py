# read in num test cases
num_tests: int = int(input())
lines: str = []
for i in range(0, num_tests):
    lines.append(input())
    lines.append(input())

# for number of tests
for i in range(0, num_tests):
    num_houses: int = int(lines[i * 2])
    trash_bins: str = lines[(i * 2) + 1]
    trash_array = []
    for char in trash_bins:
        if char == '0':
            trash_array.append(0)
        else:
            trash_array.append(1)
    trash_sum: int = 0
    for j in range(0, len(trash_array)):
        forward: int = j
        backward: int = j
        found: int = -1
        forward_cond: bool = True
        backward_cond: bool = True
        while ((forward_cond or backward_cond) and found == -1):
            if forward < len(trash_array):
                if trash_array[forward]:
                    forward_cond = False
                    found = forward
                else:
                    forward += 1
            else:
                forward_cond = False
                
            if backward >= 0:
                if trash_array[backward]:
                    backward_cond = False
                    found = backward
                else:
                    backward -= 1
            else:
                backward_cond = False
        trash_sum += abs(j - found)
    print('Case #' + str(i + 1) + ': ' + str(trash_sum))