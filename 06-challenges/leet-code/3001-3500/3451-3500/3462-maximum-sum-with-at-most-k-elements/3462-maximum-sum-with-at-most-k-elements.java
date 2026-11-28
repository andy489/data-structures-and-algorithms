// https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/

// Solution: Greedy with Global Max Heap — O(n*m*log(n*m)) time, O(n*m) space
class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int[] row = grid[i].clone();
            Arrays.sort(row);
            int limit = limits[i];
            for (int j = row.length - 1; j >= row.length - limit; j--) {
                pq.offer(row[j]);
            }
        }
        long sum = 0;
        int taken = 0;
        while (!pq.isEmpty() && taken < k) {
            sum += pq.poll();
            taken++;
        }
        return sum;
    }
}
