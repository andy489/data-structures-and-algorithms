// https://leetcode.com/problems/frog-position-after-t-seconds/

// Solution: BFS with probability — O(n) time, O(n) space
class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }
        double[] prob = new double[n+1];
        prob[1] = 1.0;
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        for (int sec = 0; sec < t && !q.isEmpty(); sec++) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                List<Integer> unvisited = new ArrayList<>();
                for (int nb : adj.get(cur)) if (!visited[nb]) unvisited.add(nb);
                if (unvisited.isEmpty()) continue;
                for (int nb : unvisited) {
                    visited[nb] = true;
                    prob[nb] = prob[cur] / unvisited.size();
                    q.offer(nb);
                }
                prob[cur] = 0;
            }
        }
        return prob[target];
    }
}
