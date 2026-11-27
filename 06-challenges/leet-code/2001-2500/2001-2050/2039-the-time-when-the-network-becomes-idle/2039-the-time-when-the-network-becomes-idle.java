// https://leetcode.com/problems/the-time-when-the-network-becomes-idle/

// Solution: BFS + Math — O(V+E) time, O(V+E) space
class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) { adj.add(new ArrayList<>()); }
        for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) { dist[v] = dist[u] + 1; q.offer(v); }
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int d = 2 * dist[i];
            int resends = (d - 1) / patience[i];
            int lastSend = patience[i] * resends;
            int lastArrival = lastSend + d;
            ans = Math.max(ans, lastArrival + 1);
        }
        return ans;
    }
}
