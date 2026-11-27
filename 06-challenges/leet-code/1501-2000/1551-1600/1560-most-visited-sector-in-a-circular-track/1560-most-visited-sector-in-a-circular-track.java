// https://leetcode.com/problems/most-visited-sector-in-a-circular-track/

// Solution: Start and End Comparison — O(n) time, O(n) space
class Solution {
    public java.util.List<Integer> mostVisited(int n, int[] rounds) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        int start = rounds[0], end = rounds[rounds.length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                result.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                result.add(i);
            }
            for (int i = start; i <= n; i++) {
                result.add(i);
            }
        }
        return result;
    }
}
