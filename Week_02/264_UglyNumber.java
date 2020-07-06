import java.util.PriorityQueue;

class Solution {
    // Priority Queue
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1l);

        for (int i = 1; i < n; ++i) {
            long cur = queue.poll();
            while (!queue.isEmpty() && queue.peek() == cur) {
                queue.poll();
            }
            queue.offer(cur * 2);
            queue.offer(cur * 3);
            queue.offer(cur * 5);
        }

        return queue.peek().intValue();
    }

    // DP
    public int nthUglyNumber2(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int f2 = 1, f3 = 1, f5 = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.min(Math.min(2 * dp[f2], 3 * dp[f3]), 5 * dp[f5]);
            
            if (dp[i] == 2 * dp[f2]) {
                ++f2;
            }
            if (dp[i] == 3 * dp[f3]) {
                ++f3;
            }
            if (dp[i] == 5 * dp[f5]) {
                ++f5;
            }
        }
        return dp[n];
    }
}