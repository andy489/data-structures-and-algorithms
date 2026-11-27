// https://leetcode.com/problems/zero-array-transformation-iii/

// Solution: Greedy + Max-Heap (Sweep Line) — O((n + q) log q) time, O(n + q) space
class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        // Group queries by their left endpoint
        List<List<Integer>> byLeft = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            byLeft.add(new ArrayList<>());
        }
        for (int[] query : queries) {
            byLeft.get(query[0]).add(query[1]);
        }

        // Max-heap of right endpoints
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int[] diff = new int[n + 1];
        int coverage = 0;
        int used = 0;

        for (int i = 0; i < n; i++) {
            coverage += diff[i];
            // Add all queries starting at i
            for (int r : byLeft.get(i)) {
                heap.offer(r);
            }
            // Greedily pick queries with largest r to cover deficit
            while (coverage < nums[i]) {
                if (heap.isEmpty() || heap.peek() < i) {
                    return -1;
                }
                int r = heap.poll();
                diff[i]++;
                diff[r + 1]--;
                coverage++;
                used++;
            }
        }
        return q - used;
    }
}
