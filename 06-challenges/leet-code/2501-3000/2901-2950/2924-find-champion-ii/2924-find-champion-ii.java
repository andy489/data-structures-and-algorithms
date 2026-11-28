// https://leetcode.com/problems/find-champion-ii/

// Solution: In-Degree Count — O(n + m) time, O(n) space
class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        int champion = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                champion = i;
                count++;
            }
        }
        return count == 1 ? champion : -1;
    }
}
