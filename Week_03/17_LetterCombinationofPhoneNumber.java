class Solution {
    private static final String[] KEYS = {"abc", "def", "ghi", "jkl", 
                                          "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backtrack("", digits, result);
        return result;
    }
    
    private void backtrack(String cur, String digits, List<String> result) {
        if (cur.length() == digits.length()) {
            if (!cur.isEmpty()) {
               result.add(cur);
            }
            return;
        }
        
        String keys = KEYS[digits.charAt(cur.length()) - '2'];
        for (char c : keys.toCharArray()) {
            backtrack(cur + c, digits, result);
        }
    }
}