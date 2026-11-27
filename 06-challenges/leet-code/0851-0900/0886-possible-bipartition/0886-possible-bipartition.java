// https://leetcode.com/problems/possible-bipartition/

// Solution: BFS Graph Coloring — O(n+e) time, O(n+e) space
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) { graph[i] = new ArrayList<>(); }
        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) { continue; }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 1;
            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : graph[u]) {
                    if (color[v] == 0) {
                        color[v] = -color[u];
                        queue.offer(v);
                    } else if (color[v] == color[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
