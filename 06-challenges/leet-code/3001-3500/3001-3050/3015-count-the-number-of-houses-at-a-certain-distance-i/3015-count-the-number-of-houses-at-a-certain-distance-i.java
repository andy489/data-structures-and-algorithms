// https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/

// Solution: BFS All-Pairs — O(n²) time, O(n²) space
class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { adj.add(new ArrayList<>()); }
        for (int i = 1; i < n; i++) { adj.get(i).add(i+1); adj.get(i+1).add(i); }
        if (x != y) { adj.get(x).add(y); adj.get(y).add(x); }
        int[] answer = new int[n + 1];
        for (int src = 1; src <= n; src++) {
            int[] dist = bfs(src, n, adj);
            for (int dst = 1; dst <= n; dst++) {
                if (dst != src && dist[dst] > 0) { answer[dist[dst]]++; }
            }
        }
        return java.util.Arrays.copyOfRange(answer, 1, n + 1);
    }

    private int[] bfs(int src, int n, List<List<Integer>> adj) {
        int[] dist = new int[n + 1];
        java.util.Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(src); dist[src] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) { dist[v] = dist[u] + 1; q.offer(v); }
            }
        }
        return dist;
    }
}
