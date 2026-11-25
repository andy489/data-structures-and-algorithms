// https://leetcode.com/problems/distant-barcodes/

// Solution: Greedy with Max Heap — O(n log k) time, O(n) space
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int b : barcodes) {
            freq.merge(b, 1, Integer::sum);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (var e : freq.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }
        int[] res = new int[barcodes.length];
        int idx = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (idx > 0 && res[idx - 1] == top[0]) {
                int[] second = pq.poll();
                res[idx++] = second[0];
                if (--second[1] > 0) { pq.offer(second); }
                pq.offer(top);
            } else {
                res[idx++] = top[0];
                if (--top[1] > 0) { pq.offer(top); }
            }
        }
        return res;
    }
}
