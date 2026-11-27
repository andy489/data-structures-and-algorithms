// https://leetcode.com/problems/minimize-the-maximum-edge-weight-of-graph/

class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        int lo = 1, hi = 1_000_000, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canReach(n, edges, threshold, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean canReach(int n, int[][] edges, int threshold, int maxW) {
        // Build reverse graph: for each node, store incoming edges (original outgoing) with weight <= maxW
        // We want all nodes to reach 0, so we reverse: build graph where 0 can reach all nodes
        List<List<int[]>> revAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            revAdj.add(new ArrayList<>());
        }
        int[] outCount = new int[n];
        // For each original edge u->v with weight w <= maxW, add to reverse adj v->u
        // But each node u can have at most threshold outgoing edges
        // Sort edges by weight to pick smallest threshold edges per node
        Map<Integer, List<int[]>> byFrom = new HashMap<>();
        for (int[] e : edges) {
            if (e[2] <= maxW) {
                byFrom.computeIfAbsent(e[0], x -> new ArrayList<>()).add(new int[]{e[1], e[2]});
            }
        }
        for (Map.Entry<Integer, List<int[]>> entry : byFrom.entrySet()) {
            int u = entry.getKey();
            List<int[]> outEdges = entry.getValue();
            outEdges.sort((a, b) -> a[1] - b[1]);
            int count = 0;
            for (int[] oe : outEdges) {
                if (count >= threshold) {
                    break;
                }
                revAdj.get(oe[0]).add(new int[]{u});
                count++;
            }
        }
        // BFS from 0 on reverse graph
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] nb : revAdj.get(cur)) {
                if (!visited[nb[0]]) {
                    visited[nb[0]] = true;
                    queue.add(nb[0]);
                }
            }
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
