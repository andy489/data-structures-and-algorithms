// https://leetcode.com/problems/path-with-maximum-probability/

// Solution: Modified Dijkstra (Max-Heap) — O((V + E) log V) time, O(V + E) space
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double p = succProb[i];
            adj[u].add(new double[]{v, p});
            adj[v].add(new double[]{u, p});
        }
        double[] prob = new double[n];
        prob[start] = 1.0;
        // max-heap by probability
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1.0});
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int u = (int) cur[0];
            double p = cur[1];
            if (p < prob[u]) {
                continue;
            }
            if (u == end) {
                return p;
            }
            for (double[] next : adj[u]) {
                int v = (int) next[0];
                double np = p * next[1];
                if (np > prob[v]) {
                    prob[v] = np;
                    pq.offer(new double[]{v, np});
                }
            }
        }
        return 0.0;
    }
}
