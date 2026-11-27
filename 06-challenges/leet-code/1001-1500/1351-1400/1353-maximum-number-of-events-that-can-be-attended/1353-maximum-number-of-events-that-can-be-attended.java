// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/

// Solution: Greedy + Min-Heap — O(n log n) time, O(n) space
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0, i = 0, n = events.length;
        for (int day = 1; day <= 100000; day++) {
            while (i < n && events[i][0] == day) pq.offer(events[i++][1]);
            while (!pq.isEmpty() && pq.peek() < day) pq.poll();
            if (!pq.isEmpty()) { pq.poll(); count++; }
            if (pq.isEmpty() && i == n) break;
        }
        return count;
    }
}
