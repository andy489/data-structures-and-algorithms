// https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/

// Solution: Union-Find (Group Matching) — O(n · α(n)) time, O(n) space
class Solution {
    private int[] parent;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra != rb) {
            parent[ra] = rb;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int dist = 0;
        for (List<Integer> group : groups.values()) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int idx : group) {
                freq.merge(source[idx], 1, Integer::sum);
            }
            for (int idx : group) {
                int t = target[idx];
                if (freq.getOrDefault(t, 0) > 0) {
                    freq.merge(t, -1, Integer::sum);
                } else {
                    dist++;
                }
            }
        }
        return dist;
    }
}
