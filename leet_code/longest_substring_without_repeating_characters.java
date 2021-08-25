import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // convert string to char array
        char[] string = new char[s.length()];
        for (int i = 0; i < string.length; i++) {
            string[i] = s.charAt(i);
        }
        
        // instantiate new HashSet object
        int max_len = 0;
        HashSet<Character> included = new HashSet<Character>();
        for (int i = 0; i < string.length; i++) {
            System.out.println(string[i]);
            int temp_len = 0;
            boolean flag = true;
            int j = i;
            included.removeAll(included);
            for (; j <  string.length && flag; j++) {
                if (!included.contains(string[j])) {
                    included.add(string[j]);
                    temp_len++;
                } else {
                    flag = false;
                }
            }
            
            if (temp_len > max_len) {
                max_len = temp_len;
            }
        }
        return max_len;
    }
}