// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

// Solution: BFS from Root — O(n) time, O(n) space
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] c : connections) {
            adj.get(c[0]).add(new int[]{c[1], 1});
            adj.get(c[1]).add(new int[]{c[0], 0});
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); visited[0] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] e : adj.get(u)) {
                if (!visited[e[0]]) {
                    count += e[1];
                    visited[e[0]] = true;
                    q.offer(e[0]);
                }
            }
        }
        return count;
    }
}
