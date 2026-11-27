// https://leetcode.com/problems/critical-connections-in-a-network/

// Solution: Tarjan's Bridge-Finding Algorithm — O(V+E) time, O(V+E) space
class Solution {
    private int timer = 0;
    private int[] disc;
    private int[] low;
    private List<List<Integer>> graph;
    private List<List<Integer>> bridges;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc = new int[n];
        low = new int[n];
        Arrays.fill(disc, -1);
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> conn : connections) {
            int u = conn.get(0), v = conn.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        bridges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, -1);
            }
        }
        return bridges;
    }

    private void dfs(int u, int parent) {
        disc[u] = low[u] = timer++;
        for (int v : graph.get(u)) {
            if (v == parent) {
                continue;
            }
            if (disc[v] == -1) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
