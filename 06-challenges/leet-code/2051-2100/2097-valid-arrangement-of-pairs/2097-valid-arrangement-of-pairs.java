// https://leetcode.com/problems/valid-arrangement-of-pairs/

// Solution: Eulerian Path (Hierholzer) — O(n) time, O(n) space
class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> outDeg = new HashMap<>(), inDeg = new HashMap<>();
        for (int[] p : pairs) {
            graph.computeIfAbsent(p[0], k -> new ArrayDeque<>()).add(p[1]);
            outDeg.merge(p[0], 1, Integer::sum);
            inDeg.merge(p[1], 1, Integer::sum);
        }
        int start = pairs[0][0];
        for (int node : outDeg.keySet()) {
            if (outDeg.get(node) - inDeg.getOrDefault(node, 0) == 1) { start = node; break; }
        }
        List<Integer> path = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int u = stack.peek();
            Deque<Integer> neighbors = graph.get(u);
            if (neighbors != null && !neighbors.isEmpty()) { stack.push(neighbors.poll()); }
            else { path.add(stack.pop()); }
        }
        Collections.reverse(path);
        int n = path.size();
        int[][] res = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) { res[i] = new int[]{path.get(i), path.get(i + 1)}; }
        return res;
    }
}
