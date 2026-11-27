// https://leetcode.com/problems/magnetic-force-between-two-balls/

// Solution: Binary Search on Answer — O(n log n + n log D) time, O(1) space
class Solution {
    public int maxDistance(int[] position, int m) {
        java.util.Arrays.sort(position);
        int lo = 1, hi = position[position.length - 1] - position[0];
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (canPlace(position, m, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean canPlace(int[] pos, int m, int minDist) {
        int count = 1, last = pos[0];
        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - last >= minDist) {
                count++;
                last = pos[i];
                if (count == m) {
                    return true;
                }
            }
        }
        return count >= m;
    }
}
