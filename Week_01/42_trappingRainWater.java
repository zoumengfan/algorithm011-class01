class Solution {
    // solution 1
    public int trap(int[] height) {
        int result = 0;
        int i = 0;

        while (i < height.length - 1) {
            int j = i + 1;
            int max = j;
            while (j < height.length && height[j] <= height[i]) {
                if (height[max] < height[j]) {
                    max = j;
                }
                j++;
            }

            if (j < height.length) {
                max = j;
            }
            
            result += calculateArea(height, i, max);
            i = max;
        }

        return result;
    }

    private int calculateArea(int[] height, int i, int j) {
        int area = 0;
        int low = Math.min(height[i], height[j]);

        for (int x = i; x < j; x++) {
            if (height[x] >= low) {
                continue;
            }
            area += low - height[x];
        }
        return area;
    }

    // solution 2
    public int trap2(int[] height) {
        int i = 0, j = height.length - 1;
        while (i < j && height[i + 1] > height[i]) {
            i++;
        }
        
        while (j > i && height[j] < height[j - 1]) {
            j--;
        }
        
        int result = 0;
        while (i < j) {
            int left = height[i];
            int right = height[j];
            if (left < right) {
                while (i < j && left > height[++i]) {
                    result += (left - height[i]);
                }
            } else {
                while (j > i && right > height[--j]) {
                    result += (right - height[j]);
                }
            }
        }
        return result;
    }

    // solution 3
    
}
