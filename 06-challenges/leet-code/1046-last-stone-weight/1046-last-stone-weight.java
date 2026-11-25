// https://leetcode.com/problems/last-stone-weight/

// Solution: Max Heap — O(n log n) time, O(n) space
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            pq.offer(s);
        }
        while (pq.size() > 1) {
            int y = pq.poll(), x = pq.poll();
            if (y != x) {
                pq.offer(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
