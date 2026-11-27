// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

// Solution: Nodes With No Incoming Edge — O(n + e) time, O(n) space
class Solution {
    public java.util.List<Integer> findSmallestSetOfVertices(int n, java.util.List<java.util.List<Integer>> edges) {
        boolean[] hasIncoming = new boolean[n];
        for (java.util.List<Integer> edge : edges) {
            hasIncoming[edge.get(1)] = true;
        }
        java.util.List<Integer> result = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasIncoming[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
