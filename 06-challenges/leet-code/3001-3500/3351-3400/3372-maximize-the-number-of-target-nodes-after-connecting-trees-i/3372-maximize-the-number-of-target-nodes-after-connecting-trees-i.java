// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/

// Solution: BFS from Each Node — O(n·m) time, O(n + m) space
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> adj1 = buildAdj(edges1, n);
        List<List<Integer>> adj2 = buildAdj(edges2, m);

        int best2 = 0;
        if (k > 0) {
            for (int j = 0; j < m; j++) {
                best2 = Math.max(best2, bfsCount(adj2, j, k - 1, m));
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = bfsCount(adj1, i, k, n) + best2;
        }
        return answer;
    }

    private List<List<Integer>> buildAdj(int[][] edges, int size) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }

    private int bfsCount(List<List<Integer>> adj, int src, int maxDist, int size) {
        int[] dist = new int[size];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        int count = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (dist[v] <= maxDist) {
                count++;
                for (int nb : adj.get(v)) {
                    if (dist[nb] == -1) {
                        dist[nb] = dist[v] + 1;
                        if (dist[nb] <= maxDist) {
                            queue.add(nb);
                        }
                    }
                }
            }
        }
        return count;
    }
}
