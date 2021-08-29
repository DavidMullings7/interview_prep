class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        
        // create list of found cities
        HashSet<Integer> found = new HashSet<Integer>();
        
        // continue searching for provinces until all cities have been found
        int provinces = 0;
        int i = 0;
        while (found.size() != isConnected.length) {
            provinces += helper(isConnected, found, i);
            i++;
        }
        
        return provinces;
    }
    
    public int helper(int[][] isConnected, HashSet<Integer> found, int city) {
        
        // if city is already found, return 0
        if (found.contains(city)) {
            return 0;
        }
        
        // continue searching for cities recursively
        found.add(city);
        for (int i = 0; i < isConnected[city].length; i++)  {
            if (isConnected[city][i] == 1) {
                helper(isConnected, found, i);
            }
        }
        return 1;
    }
}