class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            int n = count.getOrDefault(i, 0);
            count.put(i, n + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            queue.offer(entry);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = queue.poll().getKey();
        }
        
        return result;
    }
}