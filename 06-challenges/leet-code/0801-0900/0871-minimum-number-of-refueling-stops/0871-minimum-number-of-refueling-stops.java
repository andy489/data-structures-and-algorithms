// https://leetcode.com/problems/minimum-number-of-refueling-stops/

// Solution: Greedy with Max-Heap — O(n log n) time, O(n) space
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int fuel = startFuel, stops = 0, prev = 0;
        for (int[] station : stations) {
            int pos = station[0], cap = station[1];
            fuel -= (pos - prev);
            while (fuel < 0 && !maxHeap.isEmpty()) {
                fuel += maxHeap.poll();
                stops++;
            }
            if (fuel < 0) {
                return -1;
            }
            maxHeap.offer(cap);
            prev = pos;
        }
        fuel -= (target - prev);
        while (fuel < 0 && !maxHeap.isEmpty()) {
            fuel += maxHeap.poll();
            stops++;
        }
        return fuel >= 0 ? stops : -1;
    }
}
