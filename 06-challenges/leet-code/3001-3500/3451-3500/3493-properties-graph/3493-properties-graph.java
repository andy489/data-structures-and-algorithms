// https://leetcode.com/problems/properties-graph/

// Solution: Union-Find with Set Intersection — O(n^2 * m) time, O(n * m) space
class Solution {
    private int[] parent;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra != rb) {
            parent[ra] = rb;
        }
    }

    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Set<Integer>[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
            for (int val : properties[i]) {
                sets[i].add(val);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                for (int val : sets[i]) {
                    if (sets[j].contains(val)) {
                        count++;
                    }
                }
                if (count >= k) {
                    union(i, j);
                }
            }
        }

        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            roots.add(find(i));
        }
        return roots.size();
    }
}
