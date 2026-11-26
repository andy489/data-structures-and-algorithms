// https://leetcode.com/problems/maximal-network-rank/

// Solution: Degree Count + Edge Check — O(n^2) time, O(n + e) space
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        boolean[][] connected = new boolean[n][n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degree[i] + degree[j] - (connected[i][j] ? 1 : 0);
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}
