// https://leetcode.com/problems/height-checker/

// Solution: Sort and Compare — O(n log n) time, O(n) space
class Solution {
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) {
                count++;
            }
        }
        return count;
    }
}
