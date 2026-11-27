// https://leetcode.com/problems/button-with-longest-push-time/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int bestIdx = events[0][0];
        int bestTime = events[0][1];
        for (int i = 1; i < events.length; i++) {
            int duration = events[i][1] - events[i - 1][1];
            if (duration > bestTime || (duration == bestTime && events[i][0] < bestIdx)) {
                bestTime = duration;
                bestIdx = events[i][0];
            }
        }
        return bestIdx;
    }
}
