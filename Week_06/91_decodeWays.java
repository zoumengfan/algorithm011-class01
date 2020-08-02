class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        char[] arr = s.toCharArray();
        dp[0] = 1;
        dp[1] = (arr[0] > '0') ? 1 : 0;
        
        for (int i = 2; i <= arr.length; ++i) {
            if (arr[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            
            int val = 10 * (arr[i - 2] - '0') + (arr[i - 1] - '0');
            if (val >= 10 && val <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}