class Solution {
    // solution 1
    public int trap(int[] height) {
        int result = 0;
        int i = 0, j = height.length - 1;
        
        while (i < j && height[i] < height[i + 1]) {
            ++i;
        }
        
        while (i < j && height[j] < height[j - 1]) {
            --j;
        }
        
        while (i < j) {
            int left = height[i];
            int right = height[j];
            
            if (left < right) {
                while (i < j && left > height[++i]) {
                    result += left - height[i];
                }
                
            } else {
                while (i < j && right > height[--j]) {
                    result += right - height[j];
                }
            }
        }
        return result;
    }

    // solution 2
    public int trap2(int[] height) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int h = Math.min(height[i], height[stack.peek()]) - height[pop];
                int w = i - stack.peek() - 1;
                result += h * w;
            }
            stack.push(i);
        }
        
        return result;
    }
    
}
