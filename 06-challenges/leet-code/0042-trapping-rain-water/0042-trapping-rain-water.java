// https://leetcode.com/problems/trapping-rain-water/

// Solution: Two pointers — O(n) time, O(1) space
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = 0, maxR = 0, water = 0;
        while (l < r) {
            if (maxL <= maxR) {
                maxL = Math.max(maxL, height[l]);
                water += maxL - height[l];
                l++;
            } else {
                maxR = Math.max(maxR, height[r]);
                water += maxR - height[r];
                r--;
            }
        }
        return water;
    }
}

// Solution2: Precomputed prefix/suffix max arrays — O(n) time, O(n) space
class Solution2 {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}
