// https://leetcode.com/problems/corporate-flight-bookings/

// Solution: Difference Array — O(n + m) time, O(n) space
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 2];
        for (int[] b : bookings) {
            diff[b[0]] += b[2];
            diff[b[1] + 1] -= b[2];
        }
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += diff[i];
            ans[i - 1] = sum;
        }
        return ans;
    }
}
