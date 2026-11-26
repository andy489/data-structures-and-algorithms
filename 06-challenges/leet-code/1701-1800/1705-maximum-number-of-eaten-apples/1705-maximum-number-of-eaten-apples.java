// https://leetcode.com/problems/maximum-number-of-eaten-apples/

// Solution: Greedy with Min-Heap — O(n log n) time, O(n) space
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = apples.length;
        int eaten = 0;
        int i = 0;
        while (i < n || !heap.isEmpty()) {
            if (i < n && apples[i] > 0) {
                heap.offer(new int[]{i + days[i], apples[i]});
            }
            while (!heap.isEmpty() && heap.peek()[0] <= i) {
                heap.poll();
            }
            if (!heap.isEmpty()) {
                int[] top = heap.peek();
                top[1]--;
                if (top[1] == 0) {
                    heap.poll();
                }
                eaten++;
            }
            i++;
        }
        return eaten;
    }
}
