// https://leetcode.com/problems/k-th-smallest-prime-fraction/

// Solution: Min-Heap — O(k log n) time, O(n) space
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) ->
            Double.compare((double) arr[a[0]] / arr[a[1]], (double) arr[b[0]] / arr[b[1]]));
        for (int i = 0; i < n - 1; i++) {
            heap.offer(new int[]{i, n - 1});
        }
        while (--k > 0) {
            int[] top = heap.poll();
            int i = top[0], j = top[1];
            if (j - 1 > i) {
                heap.offer(new int[]{i, j - 1});
            }
        }
        int[] top = heap.poll();
        return new int[]{arr[top[0]], arr[top[1]]};
    }
}
