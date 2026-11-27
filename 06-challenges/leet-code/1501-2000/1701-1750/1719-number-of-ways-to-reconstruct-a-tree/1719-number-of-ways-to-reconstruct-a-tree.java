// https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/

// Solution: Graph Analysis + Degree Comparison — O(n^2) time, O(n^2) space
class Solution {
    public int checkWays(int[][] pairs) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] pair : pairs) {
            adj.computeIfAbsent(pair[0], k -> new HashSet<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], k -> new HashSet<>()).add(pair[0]);
        }
        int n = adj.size();
        List<Integer> nodes = new ArrayList<>(adj.keySet());
        nodes.sort((a, b) -> adj.get(a).size() - adj.get(b).size());

        boolean multiple = false;
        for (int i = 0; i < nodes.size(); i++) {
            int u = nodes.get(i);
            Set<Integer> uAdj = adj.get(u);
            // Include u itself as a "self-neighbor" for degree check
            int degU = uAdj.size() + 1;

            // Find parent: smallest-degree neighbor with degree >= degU
            int parent = -1;
            int minDeg = Integer.MAX_VALUE;
            for (int v : uAdj) {
                int degV = adj.get(v).size() + 1;
                if (degV >= degU && degV < minDeg) {
                    minDeg = degV;
                    parent = v;
                }
            }

            if (parent == -1) {
                // u should be root; check deg == n
                if (degU != n) {
                    return 0;
                }
            } else {
                Set<Integer> pAdj = adj.get(parent);
                // All neighbors of u (except parent) must be neighbors of parent
                for (int v : uAdj) {
                    if (v != parent && !pAdj.contains(v)) {
                        return 0;
                    }
                }
                if (adj.get(parent).size() == uAdj.size()) {
                    multiple = true;
                }
            }
        }
        return multiple ? 2 : 1;
    }
}
