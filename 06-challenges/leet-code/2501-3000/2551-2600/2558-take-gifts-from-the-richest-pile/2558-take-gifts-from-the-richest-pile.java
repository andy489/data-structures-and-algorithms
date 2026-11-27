// https://leetcode.com/problems/take-gifts-from-the-richest-pile/

// Solution: Max-Heap — O((n + k) log n) time, O(n) space
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int g : gifts) {
            maxHeap.offer(g);
        }
        for (int i = 0; i < k; i++) {
            int max = maxHeap.poll();
            maxHeap.offer((int) Math.sqrt(max));
        }
        long total = 0;
        for (int g : maxHeap) {
            total += g;
        }
        return total;
    }
}
