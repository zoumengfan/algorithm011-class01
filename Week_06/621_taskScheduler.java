class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            ++count[c - 'A'];
        }
        
        Arrays.sort(count);
        int maxCount = count[25];
        int max = (maxCount - 1) * (n + 1) + 1;
        
        for (int i = 24; i >= 0; --i) {
            if (count[i] != maxCount) {
                break;
            }
            ++max;
        }
        
        return Math.max(tasks.length, max);
    }
}