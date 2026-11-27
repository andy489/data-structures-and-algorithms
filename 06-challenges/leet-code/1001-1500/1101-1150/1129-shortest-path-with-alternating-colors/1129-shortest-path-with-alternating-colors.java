// https://leetcode.com/problems/shortest-path-with-alternating-colors/

// Solution: BFS with Color State — O(n + E) time, O(n + E) space
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // adj[color] = list of neighbors reachable via that color
        List<List<Integer>> red = new ArrayList<>();
        List<List<Integer>> blue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }
        for (int[] e : redEdges) {
            red.get(e[0]).add(e[1]);
        }
        for (int[] e : blueEdges) {
            blue.get(e[0]).add(e[1]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;

        // visited[node][color]: 0=red, 1=blue
        boolean[][] visited = new boolean[n][2];
        // queue entries: [node, lastColor]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // arrived at 0 via red (fictitious)
        queue.offer(new int[]{0, 1}); // arrived at 0 via blue (fictitious)
        visited[0][0] = true;
        visited[0][1] = true;

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int node = cur[0];
                int color = cur[1];
                // next edge must be opposite color
                List<Integer> neighbors = color == 0 ? blue.get(node) : red.get(node);
                int nextColor = 1 - color;
                for (int nb : neighbors) {
                    if (!visited[nb][nextColor]) {
                        visited[nb][nextColor] = true;
                        if (ans[nb] == -1) {
                            ans[nb] = dist;
                        }
                        queue.offer(new int[]{nb, nextColor});
                    }
                }
            }
        }
        return ans;
    }
}
