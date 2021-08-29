class Solution {
    public int findCenter(int[][] edges) {
        
        // create array of nodes
        int[] nodes = new int[edges.length + 1];

        // populate edge counts for each node
        for (int i = 0; i < edges.length; i++) {
            nodes[edges[i][0] - 1]++;
            nodes[edges[i][1] - 1]++;
        }

        // check for every node, return index if node edge count == n - 1
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == nodes.length - 1) {
                return i + 1;
            }
        }
        
        // no center node found
        return -1;
    }
}