// https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/
class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            inDegree[favorite[i]]++;
            reverseGraph.get(favorite[i]).add(i);
        }

        // Topological sort to remove non-cycle nodes
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        boolean[] onCycle = new boolean[n];
        Arrays.fill(onCycle, true);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            onCycle[node] = false;
            int next = favorite[node];
            if (--inDegree[next] == 0) {
                queue.offer(next);
            }
        }

        // BFS to find max chain depth from a cycle node into non-cycle nodes
        int[] depth = new int[n];
        // Process non-cycle nodes in reverse topological order
        // Re-run BFS on reversed graph from each cycle node
        int maxCycle = 0;
        int sumChains = 0;

        // Find cycles
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (onCycle[i] && !visited[i]) {
                // Traverse cycle
                int cycleLen = 0;
                int cur = i;
                while (!visited[cur]) {
                    visited[cur] = true;
                    cur = favorite[cur];
                    cycleLen++;
                }
                if (cycleLen == 2) {
                    // 2-cycle: BFS from both nodes into tails
                    int a = i, b = favorite[i];
                    int depthA = bfsDepth(a, b, reverseGraph, onCycle);
                    int depthB = bfsDepth(b, a, reverseGraph, onCycle);
                    sumChains += depthA + depthB;
                } else {
                    maxCycle = Math.max(maxCycle, cycleLen);
                }
            }
        }
        return Math.max(maxCycle, sumChains);
    }

    private int bfsDepth(int start, int exclude, List<List<Integer>> reverseGraph, boolean[] onCycle) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 1});
        int maxDepth = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], d = curr[1];
            maxDepth = Math.max(maxDepth, d);
            for (int prev : reverseGraph.get(node)) {
                if (prev != exclude && !onCycle[prev]) {
                    queue.offer(new int[]{prev, d + 1});
                }
            }
        }
        return maxDepth;
    }
}
