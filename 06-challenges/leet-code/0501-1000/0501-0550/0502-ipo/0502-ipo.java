// https://leetcode.com/problems/ipo/

// Solution: Greedy + Min-heap + Max-heap — O(n log n) time, O(n) space
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        // min-heap by capital
        PriorityQueue<int[]> byCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] p : projects) {
            byCapital.offer(p);
        }
        // max-heap by profit
        PriorityQueue<Integer> byProfit = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            while (!byCapital.isEmpty() && byCapital.peek()[0] <= w) {
                byProfit.offer(byCapital.poll()[1]);
            }
            if (byProfit.isEmpty()) {
                break;
            }
            w += byProfit.poll();
        }
        return w;
    }
}
