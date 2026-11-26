// https://leetcode.com/problems/min-cost-to-connect-all-points/

// Solution: Prim's Algorithm — O(n^2) time, O(n) space
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        boolean[] inMST = new boolean[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        int totalCost = 0;
        for (int iter = 0; iter < n; iter++) {
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && (u == -1 || minDist[i] < minDist[u])) {
                    u = i;
                }
            }
            inMST[u] = true;
            totalCost += minDist[u];
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    minDist[v] = Math.min(minDist[v], dist);
                }
            }
        }
        return totalCost;
    }
}
