import java.util.PriorityQueue;

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);

        for (int i = 0; i < n - 1; ++i) {
            int cur = queue.poll();
            while (!queue.isEmpty() && queue.peek() == cur) {
                queue.poll();
            }
            queue.offer(cur * 2);
            queue.offer(cur * 3);
            queue.offer(cur * 5);
        }

        return queue.peek();
    }
}