class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }
}