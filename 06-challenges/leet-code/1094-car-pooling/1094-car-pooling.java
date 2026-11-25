// https://leetcode.com/problems/car-pooling/

// Solution: Difference Array — O(n + max_location) time, O(max_location) space
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] t : trips) {
            diff[t[1]] += t[0];
            diff[t[2]] -= t[0];
        }
        int cur = 0;
        for (int d : diff) {
            cur += d;
            if (cur > capacity) return false;
        }
        return true;
    }
}
