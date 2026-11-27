// https://leetcode.com/problems/graph-connectivity-with-threshold/

// Solution: Sieve + Union-Find — O(n log n + q * α(n)) time, O(n) space
class Solution {
    private int[] parent, rank;

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int z = threshold + 1; z <= n; z++) {
            for (int m = 2 * z; m <= n; m += z) {
                union(z, m);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(find(q[0]) == find(q[1]));
        }
        return ans;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) {
            return;
        }
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
