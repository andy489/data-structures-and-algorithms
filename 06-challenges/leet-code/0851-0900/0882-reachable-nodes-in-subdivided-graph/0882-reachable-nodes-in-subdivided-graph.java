// https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/

// Solution: Dijkstra — O((n+e) log n) time, O(n+e) space
class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{maxMoves, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int moves = cur[0], u = cur[1];
            if (dist[u] != -1) {
                continue;
            }
            dist[u] = moves;
            for (int[] nb : graph[u]) {
                int v = nb[0], cnt = nb[1];
                if (dist[v] == -1 && moves - cnt - 1 >= 0) {
                    pq.offer(new int[]{moves - cnt - 1, v});
                }
            }
        }
        int ans = 0;
        for (int d : dist) {
            if (d >= 0) {
                ans++;
            }
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            int fromU = dist[u] >= 0 ? Math.min(dist[u], cnt) : 0;
            int fromV = dist[v] >= 0 ? Math.min(dist[v], cnt) : 0;
            ans += Math.min(fromU + fromV, cnt);
        }
        return ans;
    }
}
