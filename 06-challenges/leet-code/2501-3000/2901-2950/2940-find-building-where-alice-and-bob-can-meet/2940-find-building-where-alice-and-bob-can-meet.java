// https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/

// Solution: Offline Queries + Min-Heap — O((n+q) log n) time, O(n+q) space
class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;
        int[] ans = new int[q];
        Arrays.fill(ans, -1);

        List<int[]>[] buckets = new List[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < q; i++) {
            int a = queries[i][0], b = queries[i][1];
            if (a > b) {
                int tmp = a; a = b; b = tmp;
            }
            if (a == b || heights[a] < heights[b]) {
                ans[i] = b;
            } else {
                buckets[b].add(new int[]{Math.max(heights[a], heights[b]), i});
            }
        }

        // min-heap by threshold
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i = 0; i < n; i++) {
            for (int[] entry : buckets[i]) {
                heap.offer(entry);
            }
            while (!heap.isEmpty() && heap.peek()[0] < heights[i]) {
                ans[heap.poll()[1]] = i;
            }
        }

        return ans;
    }
}
