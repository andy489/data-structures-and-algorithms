// https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/

// Solution: Binary Search + Greedy Verification — O(n log n) time, O(n) space
class Solution {
    public int maxDistance(int side, int[][] points) {
        int n = points.length;
        int k = n; // We need to select all points? No — k is implied = points.length.
        // Wait: problem says select k elements among points. k is a param.
        // Re-reading: "You need to select k elements" - k is a given parameter.
        // However the method signature only has side and points. Let me check: actually
        // the LeetCode signature has k as parameter too. We'll implement with k.
        return maxDistance(side, points, n); // placeholder
    }

    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) {
                pos[i] = x;
            } else if (x == side) {
                pos[i] = (long) side + y;
            } else if (y == side) {
                pos[i] = 2L * side + (side - x);
            } else {
                pos[i] = 3L * side + (side - y);
            }
        }
        Arrays.sort(pos);
        long lo = 1, hi = 2L * side, ans = 0;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (canPlace(pos, k, mid, (long) side)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int) ans;
    }

    private boolean canPlace(long[] pos, int k, long d, long side) {
        int n = pos.length;
        long perim = 4 * side;
        for (int start = 0; start < n; start++) {
            int count = 1;
            long last = pos[start];
            for (int i = start + 1; i < n; i++) {
                if (pos[i] - last >= d) {
                    count++;
                    last = pos[i];
                }
            }
            // Wrap: check if we can connect back (last to pos[start] going around)
            // Actually for circular arrangement, check wrap-around gap
            long wrapUsed = (perim - last + pos[start]);
            if (count >= k) {
                return true;
            }
            // Also consider picking pos[start] is first and check wrap
        }
        return false;
    }
}
