// https://leetcode.com/problems/set-intersection-size-at-least-two/

// Solution: Greedy Sort — O(n log n) time, O(1) space
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        int count = 0, p1 = -1, p2 = -1;
        for (int[] interval : intervals) {
            int s = interval[0], e = interval[1];
            if (s > p1) {
                count += 2;
                p2 = e - 1;
                p1 = e;
            } else if (s > p2) {
                count++;
                p2 = p1;
                p1 = e;
            }
        }
        return count;
    }
}
