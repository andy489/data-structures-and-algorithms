// https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/

// Solution: Topological Sort (Two-Level) — O(n + m + E) time, O(n + m + E) space
// Solution: Topological Sort (Two-Level) — O(n+m+E) time, O(n+m+E) space
class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) if (group[i] == -1) { group[i] = m++; }
        List<List<Integer>> itemGraph = new ArrayList<>(), groupGraph = new ArrayList<>();
        int[] itemDeg = new int[n], groupDeg = new int[m];
        for (int i = 0; i < n; i++) { itemGraph.add(new ArrayList<>()); }
        for (int i = 0; i < m; i++) { groupGraph.add(new ArrayList<>()); }
        for (int i = 0; i < n; i++) {
            for (int pre : beforeItems.get(i)) {
                itemGraph.get(pre).add(i); itemDeg[i]++;
                if (group[pre] != group[i]) { groupGraph.get(group[pre]).add(group[i]); groupDeg[group[i]]++; }
            }
        }
        List<Integer> itemOrder = topoSort(itemGraph, itemDeg, n);
        List<Integer> groupOrder = topoSort(groupGraph, groupDeg, m);
        if (itemOrder.isEmpty() || groupOrder.isEmpty()) return new int[0];
        Map<Integer, List<Integer>> groupItems = new HashMap<>();
        for (int x : itemOrder) groupItems.computeIfAbsent(group[x], k -> new ArrayList<>()).add(x);
        int[] res = new int[n]; int idx = 0;
        for (int g : groupOrder) for (int x : groupItems.getOrDefault(g, Collections.emptyList())) res[idx++] = x;
        return res;
    }
    private List<Integer> topoSort(List<List<Integer>> graph, int[] deg, int size) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < size; i++) if (deg[i] == 0) q.add(i);
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll(); res.add(u);
            for (int v : graph.get(u)) if (--deg[v] == 0) q.add(v);
        }
        return res.size() == size ? res : Collections.emptyList();
    }
}
