// https://leetcode.com/problems/construct-target-array-with-multiple-sums/

// Solution: Max-Heap reverse simulation — O(n log max) time, O(n) space
class Solution {
    public boolean isPossible(int[] target) {
        long total = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : target) { total += v; pq.offer((long)v); }
        while (true) {
            long max = pq.poll();
            long rest = total - max;
            if (max == 1 || rest == 1) return true;
            if (rest == 0 || max < rest) return false;
            long prev = max % rest;
            if (prev == 0) prev = rest;
            total = rest + prev;
            pq.offer(prev);
        }
    }
}
