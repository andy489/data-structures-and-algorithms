// https://leetcode.com/problems/distance-between-bus-stops/

// Solution: Prefix Sum (Two-Direction Scan) — O(n) time, O(1) space
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int total = 0;
        int clockwise = 0;
        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
            if (i >= start && i < destination) {
                clockwise += distance[i];
            }
        }
        return Math.min(clockwise, total - clockwise);
    }
}
