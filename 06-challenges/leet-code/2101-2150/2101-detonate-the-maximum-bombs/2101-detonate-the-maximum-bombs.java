// https://leetcode.com/problems/detonate-the-maximum-bombs/

// Solution: BFS on Directed Graph — O(n^3) time, O(n^2) space
class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            long xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                long dx = bombs[j][0] - xi;
                long dy = bombs[j][1] - yi;
                if (dx * dx + dy * dy <= ri * ri) {
                    graph.get(i).add(j);
                }
            }
        }

        int maxDetonated = 0;

        for (int start = 0; start < n; start++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited[start] = true;
            int count = 0;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                count++;
                for (int next : graph.get(cur)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            maxDetonated = Math.max(maxDetonated, count);
        }

        return maxDetonated;
    }
}
