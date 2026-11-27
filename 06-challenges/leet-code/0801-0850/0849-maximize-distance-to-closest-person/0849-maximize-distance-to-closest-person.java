// https://leetcode.com/problems/maximize-distance-to-closest-person/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int ans = 0, last = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (last == -1) {
                    ans = i;
                } else {
                    ans = Math.max(ans, (i - last) / 2);
                }
                last = i;
            }
        }
        ans = Math.max(ans, n - 1 - last);
        return ans;
    }
}
