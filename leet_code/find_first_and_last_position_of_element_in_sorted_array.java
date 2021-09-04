class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        // performs binary search 
        int low = 0;
        int high = nums.length - 1;
        int found = -1;
        int[] result = new int[2];
        while (low <= high && found == -1) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                found = mid;
            }
        }
        
        // returns -1 if target not found
        if (found == -1) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        
        // searches both ways for smallest / largest index of target
        low = found;
        high = found;
        int i = 1;
        while (found - i >= 0 && nums[found - i] == target) {
            low = found - i;
            i++;
        }
        
        i = 0;
        while(found + i < nums.length && nums[found + i] == target) {
            high = found + i;
            i++;
        }
        
        // populates return array
        result[0] = low;
        result[1] = high;
        
        return result;
    }
}