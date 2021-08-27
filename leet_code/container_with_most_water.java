class Solution {

    // gets next highest peak
    public int findMin(int[] height, int first, int last, int left) {
        int i = first;
        int max = height[first];
        while ((left == 1 && i < last) || (left == -1 && i > last)) {
            if (height[i] > max) {
                return i;
            }
            
            i += left;
        }
        return height.length;
    }
    
    public int maxArea(int[] height) {
        
        int max = 0;
        for (int i = 0; i < height.length  - 1; i = findMin(height, i, height.length, 1)) {
            System.out.println(i);
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * Math.min(height[i], height[j]);
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }
}