// https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double total = 0;
        for (int num : nums) {
            maxHeap.offer((double) num);
            total += num;
        }
        double target = total / 2.0;
        double reduced = 0;
        int ops = 0;
        while (reduced < target) {
            double top = maxHeap.poll();
            double half = top / 2.0;
            reduced += half;
            maxHeap.offer(half);
            ops++;
        }
        return ops;
    }
}
