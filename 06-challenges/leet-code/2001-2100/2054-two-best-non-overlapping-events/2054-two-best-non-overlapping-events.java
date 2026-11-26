// https://leetcode.com/problems/two-best-non-overlapping-events/

// Solution: Sort + Binary Search — O(n log n) time, O(n) space
class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[] prefMax = new int[n];
        prefMax[0] = events[0][2];
        for (int i = 1; i < n; i++) { prefMax[i] = Math.max(prefMax[i - 1], events[i][2]); }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int val = events[i][2];
            res = Math.max(res, val);
            int lo = 0, hi = i - 1, best = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (events[mid][1] < events[i][0]) { best = mid; lo = mid + 1; }
                else { hi = mid - 1; }
            }
            if (best >= 0) { res = Math.max(res, val + prefMax[best]); }
        }
        return res;
    }
}
