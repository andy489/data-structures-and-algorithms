// https://leetcode.com/problems/maximum-average-pass-ratio/

// Solution: Max Heap by Marginal Gain — O((n + e) log n) time, O(n) space
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max heap ordered by gain of adding one student
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );
        for (int[] c : classes) {
            double pass = c[0], total = c[1];
            double gain = (pass + 1) / (total + 1) - pass / total;
            pq.offer(new double[]{gain, pass, total});
        }
        for (int i = 0; i < extraStudents; i++) {
            double[] top = pq.poll();
            double pass = top[1] + 1, total = top[2] + 1;
            double gain = (pass + 1) / (total + 1) - pass / total;
            pq.offer(new double[]{gain, pass, total});
        }
        double sum = 0;
        for (double[] c : pq) {
            sum += c[1] / c[2];
        }
        return sum / classes.length;
    }
}
