// https://leetcode.com/problems/single-threaded-cpu/

// Solution: Sort + Min-Heap — O(n log n) time, O(n) space
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> tasks[a][0] != tasks[b][0]
                ? tasks[a][0] - tasks[b][0]
                : a - b);

        // min-heap: [processingTime, originalIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] result = new int[n];
        long time = 0;
        int idx = 0, r = 0;

        while (r < n) {
            while (idx < n && tasks[indices[idx]][0] <= time) {
                int orig = indices[idx];
                pq.offer(new int[]{tasks[orig][1], orig});
                idx++;
            }
            if (pq.isEmpty()) {
                time = tasks[indices[idx]][0];
                continue;
            }
            int[] top = pq.poll();
            result[r++] = top[1];
            time += top[0];
        }
        return result;
    }
}
