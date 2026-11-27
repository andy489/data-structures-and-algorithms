// https://leetcode.com/problems/process-restricted-friend-requests/

// Solution: Union-Find — O(r*q * α(n)) time, O(n) space
class Solution {
    int[] parent, rank;
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        parent = new int[n]; rank = new int[n];
        for (int i = 0; i < n; i++) { parent[i] = i; }
        boolean[] res = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int u = find(requests[i][0]), v = find(requests[i][1]);
            if (u == v) { res[i] = true; continue; }
            boolean ok = true;
            for (int[] r : restrictions) {
                int x = find(r[0]), y = find(r[1]);
                if ((x == u && y == v) || (x == v && y == u)) { ok = false; break; }
            }
            if (ok) { union(u, v); res[i] = true; }
        }
        return res;
    }
    int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
    void union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) { return; }
        if (rank[a] < rank[b]) { int t = a; a = b; b = t; }
        parent[b] = a;
        if (rank[a] == rank[b]) { rank[a]++; }
    }
}
