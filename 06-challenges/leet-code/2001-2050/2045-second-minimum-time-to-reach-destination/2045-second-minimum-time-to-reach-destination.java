// https://leetcode.com/problems/second-minimum-time-to-reach-destination/

// Solution: Multi-source BFS — O(V+E) time, O(V+E) space
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { adj.add(new ArrayList<>()); }
        for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }
        int[] dist1 = new int[n + 1], dist2 = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[1] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0], d = cur[1];
            for (int v : adj.get(u)) {
                if (d + 1 < dist1[v]) { dist2[v] = dist1[v]; dist1[v] = d + 1; q.offer(new int[]{v, dist1[v]}); }
                else if (d + 1 > dist1[v] && d + 1 < dist2[v]) { dist2[v] = d + 1; q.offer(new int[]{v, dist2[v]}); }
            }
        }
        int steps = dist2[n] == Integer.MAX_VALUE ? dist1[n] + 1 : dist2[n];
        int t = 0;
        for (int i = 0; i < steps; i++) {
            if ((t / change) % 2 == 1) { t = (t / change + 1) * change; }
            t += time;
        }
        return t;
    }
}
