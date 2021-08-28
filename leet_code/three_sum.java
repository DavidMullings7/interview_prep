import java.util.*;

class Solution {
    
    public int[] findOrder(int x, int y, int z) {
        
        int min_temp = Math.min(x, y);
        int min_one = Math.min(min_temp, z);
        int min_two;
        int min_three;
        if (min_one == x) {
            min_two = Math.min(y, z);
            if (y > z) {
                min_three = y;
            } else {
                min_three = z;
            }
        } else if (min_one == y) {
            min_two = Math.min(x, z);
            if (x > z) {
                min_three = x;
            } else {
                min_three = z;
            }
        } else {
            min_two = Math.min(x, y);
            if (x > y) {
                min_three = x;
            } else {
                min_three = y;
            }
        }
        
        int[] vals = {min_one, min_two, min_three};
        return vals;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        
        // brute force approach can be done in O(N^3) time with O(1) additional space
        // can be improved by storing nums in a Hash Set and iterating over [i] and [j]
        // time complexity improves to O(N^2) with O(N) additional space
        
        // construct HashMap
        HashMap<Integer, Integer> new_nums = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            new_nums.put(nums[i], i);
        }
        
        // find triplets
        HashSet<List<Integer>> product = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int nums_i = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int target = 0 - (nums_i + nums[j]);
                int index = new_nums.get(target) != null ? new_nums.get(target) : -1;
                if (index != -1 && index > j) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    int[] list = findOrder(nums_i, nums[j], target);
                    triplet.add(list[0]);
                    triplet.add(list[1]);
                    triplet.add(list[2]);
                    product.add(triplet);
                }
            }
        }
        return new ArrayList<List<Integer>>(product);
        
    }
}