class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        // create dynamic table
        boolean[][] table = new boolean[n][n];
        
        int max_len = 1;
        String max = "";
        
        // populate table along diagonal
        for (int i = 0; i < n; i++) {
            max = "" + s.charAt(i);
            table[i][i] = true;
        }
        
        // populate table along substring of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                max_len = 2;
                max = s.substring(i, i + 2);
            } else{
                table[i][i + 1] = false;
            }
        }
        
        // populate table for substrings >= length of 3
        for (int l = 3; l <= n; l++) {
            
            // iterate over substrings
            for (int i = 0; i <= n - l; i++) {
                int end = i + l -1;
                
                if (s.charAt(i) == s.charAt(end) && table[i + 1][end - 1]) {
                    table[i][end] = true;
                    if (end - i + 1 > max_len) {
                        max_len = end - i + 1;
                        max = s.substring(i, end + 1);
                    }
                } else {
                    table[i][end] = false;
                }
            }
        }
        
        return max;
    }
}