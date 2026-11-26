// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

// Solution: Graph Traversal from Endpoint — O(n) time, O(n) space
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] p : adjacentPairs) {
            adj.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
            adj.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }
        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        // Find an endpoint (degree 1)
        for (int key : adj.keySet()) {
            if (adj.get(key).size() == 1) {
                result[0] = key;
                break;
            }
        }
        result[1] = adj.get(result[0]).get(0);
        for (int i = 2; i < n; i++) {
            int prev = result[i - 2], cur = result[i - 1];
            List<Integer> neighbors = adj.get(cur);
            result[i] = neighbors.get(0) == prev ? neighbors.get(1) : neighbors.get(0);
        }
        return result;
    }
}
