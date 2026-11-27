// https://leetcode.com/problems/find-median-from-data-stream/

// Solution: Two Heaps (Max-heap + Min-heap) — O(log n) add, O(1) findMedian
class MedianFinder {
    private final PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> hi = new PriorityQueue<>();

    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());
        if (hi.size() > lo.size()) {
            lo.offer(hi.poll());
        }
    }

    public double findMedian() {
        if (lo.size() == hi.size()) {
            return (lo.peek() + hi.peek()) / 2.0;
        }
        return lo.peek();
    }
}
