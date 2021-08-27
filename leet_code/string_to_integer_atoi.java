class Solution {
    public int myAtoi(String s) {
        
        // eliminates whitespace
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        s = s.substring(i);
        
        // checks for sign
        i = 0;
        int multiplier = 1;
        if (s.length() == 0) {
            return 0;
        } else if (s.charAt(i) == '-') {
            multiplier = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // eliminates leading 0's
        String n = "0123456789";
        String new_s = "";
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        
        // gets numerical characters
        while (i < s.length() && n.contains("" + s.charAt(i))) {
            new_s = new_s + s.charAt(i);
            i++;
        }
        
        // returns immediately if number longer than max integer
        if (new_s.length() > 10) {
            if (multiplier == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } 
        
        // returns if no number included
        else if (new_s.length() == 0) {
            return 0;
        }
        
        // creates integer
        int j = 0;
        int sum = 0;
        boolean flag = true;
        for (i = new_s.length() - 1; i >= 0 && flag; i--) {
            char c = new_s.charAt(i);
            int temp = sum;
            
            // checks for integer overflow
            if (j == 9 && c != '0' && c > '2') {
                if (multiplier == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            if (c == '1') {
                sum += 1 * Math.pow(10, j) * multiplier;
            } else if (c == '2') {
                sum += 2 * Math.pow(10, j) * multiplier;
            } else if (c == '3') {
                sum += 3 * Math.pow(10, j) * multiplier;
            } else if (c == '4') {
                sum += 4 * Math.pow(10, j) * multiplier;
            } else if (c == '5') {
                sum += 5 * Math.pow(10, j) * multiplier;
            } else if (c == '6') {
                sum += 6 * Math.pow(10, j) * multiplier;
            } else if (c == '7') {
                sum += 7 * Math.pow(10, j) * multiplier;
            } else if (c == '8') {
                sum += 8 * Math.pow(10, j) * multiplier;
            } else if (c == '9') {
                sum += 9 * Math.pow(10, j) * multiplier;
            }
            
            // checks for integer overflow
            if (temp != 0 && temp / sum < 0) {
                flag = false;
                if (multiplier == 1) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            j++;
        }
        
        return sum;
    }
}