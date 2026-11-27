// https://leetcode.com/problems/count-connected-components-in-lcm-graph/

// Solution: DSU with Multiples Sweep — O(T log T + n) time, O(T + n) space
class Solution {
    private int[] parent, rank;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) {
            return;
        }
        if (rank[ra] < rank[rb]) {
            int tmp = ra; ra = rb; rb = tmp;
        }
        parent[rb] = ra;
        if (rank[ra] == rank[rb]) {
            rank[ra]++;
        }
    }

    public int countComponents(int[] nums, int threshold) {
        parent = new int[threshold + 1];
        rank = new int[threshold + 1];
        for (int i = 0; i <= threshold; i++) {
            parent[i] = i;
        }

        boolean[] present = new boolean[threshold + 1];
        int isolated = 0;
        for (int x : nums) {
            if (x > threshold) {
                isolated++;
            } else {
                present[x] = true;
            }
        }

        for (int d = 1; d <= threshold; d++) {
            int first = -1;
            for (int multiple = d; multiple <= threshold; multiple += d) {
                if (present[multiple]) {
                    if (first == -1) {
                        first = multiple;
                    } else {
                        union(first, multiple);
                    }
                }
            }
        }

        java.util.Set<Integer> roots = new java.util.HashSet<>();
        for (int x : nums) {
            if (x <= threshold) {
                roots.add(find(x));
            }
        }
        return roots.size() + isolated;
    }
}
