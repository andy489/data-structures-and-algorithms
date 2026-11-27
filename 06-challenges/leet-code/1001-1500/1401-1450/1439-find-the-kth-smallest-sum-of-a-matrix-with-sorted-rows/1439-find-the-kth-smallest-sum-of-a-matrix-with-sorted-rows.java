// https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/

// Solution: Min-Heap Merge — O(m * k log k) time, O(k) space
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int[] candidates = Arrays.copyOf(mat[0], Math.min(k, mat[0].length));
        Arrays.sort(candidates);
        for (int r = 1; r < mat.length; r++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int c : candidates)
                for (int v : mat[r]) {
                    pq.offer(c + v);
                    if (pq.size() > k) pq.poll();
                }
            candidates = new int[pq.size()];
            for (int i = candidates.length - 1; i >= 0; i--) candidates[i] = pq.poll();
        }
        return candidates[Math.min(k, candidates.length) - 1];
    }
}
