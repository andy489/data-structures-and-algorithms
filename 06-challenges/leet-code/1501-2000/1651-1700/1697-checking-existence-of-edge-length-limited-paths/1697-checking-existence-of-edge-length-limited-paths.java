// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/

// Solution: Offline Processing + Union-Find — O((E + Q) log(E + Q)) time, O(n + Q) space
class Solution {
    private int[] parent;
    private int[] rank;

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
            int tmp = px;
            px = py;
            py = tmp;
        }
        parent[py] = px;
        if (rank[px] == rank[py]) {
            rank[px]++;
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int q = queries.length;
        Integer[] qIdx = new Integer[q];
        for (int i = 0; i < q; i++) {
            qIdx[i] = i;
        }
        Arrays.sort(qIdx, (a, b) -> queries[a][2] - queries[b][2]);
        boolean[] result = new boolean[q];
        int ei = 0;
        for (int qi : qIdx) {
            int limit = queries[qi][2];
            while (ei < edgeList.length && edgeList[ei][2] < limit) {
                union(edgeList[ei][0], edgeList[ei][1]);
                ei++;
            }
            result[qi] = find(queries[qi][0]) == find(queries[qi][1]);
        }
        return result;
    }
}
