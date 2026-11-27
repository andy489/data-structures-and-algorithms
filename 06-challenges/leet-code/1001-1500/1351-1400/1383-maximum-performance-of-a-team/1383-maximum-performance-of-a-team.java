// https://leetcode.com/problems/maximum-performance-of-a-team/

// Solution: Sort + Min-Heap — O(n log k) time, O(k) space
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] eng = new int[n][2];
        for (int i = 0; i < n; i++) eng[i] = new int[]{efficiency[i], speed[i]};
        Arrays.sort(eng, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sumSpeed = 0, best = 0;
        for (int[] e : eng) {
            pq.offer(e[1]);
            sumSpeed += e[1];
            if (pq.size() > k) sumSpeed -= pq.poll();
            best = Math.max(best, sumSpeed * e[0]);
        }
        return (int)(best % 1_000_000_007L);
    }
}
