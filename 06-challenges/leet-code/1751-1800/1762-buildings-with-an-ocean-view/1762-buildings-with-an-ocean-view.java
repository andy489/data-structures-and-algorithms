// https://leetcode.com/problems/buildings-with-an-ocean-view/

// Solution: Right-to-Left Scan — O(n) time, O(1) extra space
class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> result = new ArrayList<>();
        int maxRight = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > maxRight) {
                result.add(i);
                maxRight = heights[i];
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(ans.length - 1 - i);
        }
        return ans;
    }
}
