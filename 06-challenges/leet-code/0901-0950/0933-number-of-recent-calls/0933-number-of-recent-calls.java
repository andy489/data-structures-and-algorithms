// https://leetcode.com/problems/number-of-recent-calls/

// Solution: Queue — O(1) amortized, O(n) space
class RecentCounter {
    private java.util.ArrayDeque<Integer> queue;

    public RecentCounter() {
        queue = new java.util.ArrayDeque<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
