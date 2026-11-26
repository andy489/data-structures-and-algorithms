// https://leetcode.com/problems/remove-covered-intervals/

// Solution: Sort and Sweep — O(n log n) time, O(1) space
// Solution: Sort and Sweep — O(n log n) time, O(1) space
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int count = 0, maxRight = 0;
        for (int[] iv : intervals) {
            if (iv[1] > maxRight) { count++; maxRight = iv[1]; }
        }
        return count;
    }
}
