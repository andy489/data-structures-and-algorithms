// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/

// Solution: Bipartite 2-Coloring — O(n + m) time, O(n + m) space
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> adj1 = buildAdj(edges1, n);
        List<List<Integer>> adj2 = buildAdj(edges2, m);

        int[] color1 = colorTree(adj1, n);
        int[] color2 = colorTree(adj2, m);

        int c1_0 = 0, c1_1 = 0, c2_0 = 0, c2_1 = 0;
        for (int c : color1) {
            if (c == 0) { c1_0++; } else { c1_1++; }
        }
        for (int c : color2) {
            if (c == 0) { c2_0++; } else { c2_1++; }
        }
        int best2 = Math.max(c2_0, c2_1);

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (color1[i] == 0 ? c1_0 : c1_1) + best2;
        }
        return answer;
    }

    private List<List<Integer>> buildAdj(int[][] edges, int size) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }

    private int[] colorTree(List<List<Integer>> adj, int size) {
        int[] color = new int[size];
        Arrays.fill(color, -1);
        color[0] = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int nb : adj.get(v)) {
                if (color[nb] == -1) {
                    color[nb] = 1 - color[v];
                    queue.add(nb);
                }
            }
        }
        return color;
    }
}
