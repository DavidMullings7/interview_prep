class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int[][] occurrences = new int[strs.length][26];
        for (int i = 0; i < strs.length; i++) {
            
            // construct occurrences
            String word = strs[i];
            for (int j = 0; j < word.length(); j++) {
                occurrences[i][(int) word.charAt(j) - 97]++;
            }
        }
        
        // group anagrams together based on occurrences array
        Set<Integer> checked = new HashSet<Integer>();
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < occurrences.length; i++) {
            if (!checked.contains(i)){
                List<String> product = new ArrayList<String>();
                product.add(strs[i]);
                for (int j = i + 1; j < occurrences.length; j++) {
                    if (Arrays.equals(occurrences[i], occurrences[j]) &&                                                !checked.contains(strs[j])) {
                        product.add(strs[j]);
                        checked.add(j);
                    }
                }
                result.add(product);
            }
        }
        return result;
    }
}