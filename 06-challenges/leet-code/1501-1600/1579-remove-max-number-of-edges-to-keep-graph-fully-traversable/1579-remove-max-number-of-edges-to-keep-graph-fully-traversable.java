// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

// Solution: Union-Find (Two DSUs) — O((n + e) * alpha) time, O(n) space
class Solution {
    int[] parentA, parentB, rankA, rankB;

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        parentA = new int[n + 1];
        parentB = new int[n + 1];
        rankA = new int[n + 1];
        rankB = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parentA[i] = i;
            parentB[i] = i;
        }
        int removed = 0, connA = n, connB = n;
        // Process type 3 edges first
        for (int[] e : edges) {
            if (e[0] == 3) {
                boolean ua = union(parentA, rankA, e[1], e[2]);
                boolean ub = union(parentB, rankB, e[1], e[2]);
                if (ua) {
                    connA--;
                }
                if (ub) {
                    connB--;
                }
                if (!ua && !ub) {
                    removed++;
                }
            }
        }
        // Process type 1 and 2 edges
        for (int[] e : edges) {
            if (e[0] == 1) {
                if (!union(parentA, rankA, e[1], e[2])) {
                    removed++;
                } else {
                    connA--;
                }
            } else if (e[0] == 2) {
                if (!union(parentB, rankB, e[1], e[2])) {
                    removed++;
                } else {
                    connB--;
                }
            }
        }
        return (connA == 1 && connB == 1) ? removed : -1;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private boolean union(int[] parent, int[] rank, int a, int b) {
        int ra = find(parent, a), rb = find(parent, b);
        if (ra == rb) {
            return false;
        }
        if (rank[ra] < rank[rb]) {
            parent[ra] = rb;
        } else if (rank[ra] > rank[rb]) {
            parent[rb] = ra;
        } else {
            parent[rb] = ra;
            rank[ra]++;
        }
        return true;
    }
}
