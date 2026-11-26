// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/

// Solution: Sort by Wage/Quality Ratio + Max Heap — O(n log n) time, O(n) space
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double qualitySum = 0;
        double ans = Double.MAX_VALUE;
        for (double[] worker : workers) {
            maxHeap.offer(worker[1]);
            qualitySum += worker[1];
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }
            if (maxHeap.size() == k) {
                ans = Math.min(ans, qualitySum * worker[0]);
            }
        }
        return ans;
    }
}
