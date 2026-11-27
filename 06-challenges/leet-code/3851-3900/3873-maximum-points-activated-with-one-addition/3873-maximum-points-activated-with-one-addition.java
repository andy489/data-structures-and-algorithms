// https://leetcode.com/problems/maximum-points-activated-with-one-addition/

class Solution {
    private int[] parent, rank, size;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) {
            return;
        }
        if (rank[ra] < rank[rb]) {
            int tmp = ra;
            ra = rb;
            rb = tmp;
        }
        parent[rb] = ra;
        size[ra] += size[rb];
        if (rank[ra] == rank[rb]) {
            rank[ra]++;
        }
    }

    public int maxActivated(int[][] points) {
        int n = points.length;
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Map<Integer, List<Integer>> byX = new HashMap<>();
        Map<Integer, List<Integer>> byY = new HashMap<>();
        for (int i = 0; i < n; i++) {
            byX.computeIfAbsent(points[i][0], k -> new ArrayList<>()).add(i);
            byY.computeIfAbsent(points[i][1], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> group : byX.values()) {
            for (int i = 1; i < group.size(); i++) {
                union(group.get(0), group.get(i));
            }
        }
        for (List<Integer> group : byY.values()) {
            for (int i = 1; i < group.size(); i++) {
                union(group.get(0), group.get(i));
            }
        }

        // For each component collect its x and y sets
        Map<Integer, Set<Integer>> compX = new HashMap<>();
        Map<Integer, Set<Integer>> compY = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = find(i);
            compX.computeIfAbsent(r, k -> new HashSet<>()).add(points[i][0]);
            compY.computeIfAbsent(r, k -> new HashSet<>()).add(points[i][1]);
        }

        Set<Long> existing = new HashSet<>();
        for (int[] p : points) {
            existing.add((long) p[0] * 2000000001L + p[1]);
        }

        int ans = 1; // at least the new point itself
        List<Integer> roots = new ArrayList<>(compX.keySet());
        int m = roots.size();

        // Single component: just add a point with new x,y that activates this component
        for (int r : roots) {
            ans = Math.max(ans, size[r] + 1);
        }

        // Two components: add a point (x from compA, y from compB) if not existing
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int r1 = roots.get(i), r2 = roots.get(j);
                boolean canBridge = false;
                // try x from r1 and y from r2
                outer:
                for (int x : compX.get(r1)) {
                    for (int y : compY.get(r2)) {
                        if (!existing.contains((long) x * 2000000001L + y)) {
                            canBridge = true;
                            break outer;
                        }
                    }
                }
                if (!canBridge) {
                    // try x from r2 and y from r1
                    outer2:
                    for (int x : compX.get(r2)) {
                        for (int y : compY.get(r1)) {
                            if (!existing.contains((long) x * 2000000001L + y)) {
                                canBridge = true;
                                break outer2;
                            }
                        }
                    }
                }
                if (canBridge) {
                    ans = Math.max(ans, size[r1] + size[r2] + 1);
                }
            }
        }

        return ans;
    }
}
