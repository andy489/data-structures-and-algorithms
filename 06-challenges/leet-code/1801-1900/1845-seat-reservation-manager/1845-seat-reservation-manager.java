// https://leetcode.com/problems/seat-reservation-manager/

// Solution: Min-Heap — O(n + q log n) time, O(n) space
class SeatManager {
    private PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            pq.offer(i);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
