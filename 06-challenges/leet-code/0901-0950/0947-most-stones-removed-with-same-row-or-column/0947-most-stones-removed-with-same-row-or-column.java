// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

// Solution: Union-Find — O(n α(n)) time, O(n) space
class Solution {
    java.util.Map<Integer, Integer> parent = new java.util.HashMap<>();

    int find(int x) {
        parent.putIfAbsent(x, x);
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    void union(int x, int y) {
        parent.put(find(x), find(y));
    }

    public int removeStones(int[][] stones) {
        for (int[] s : stones) {
            union(s[0], s[1] + 10001);
        }
        java.util.Set<Integer> roots = new java.util.HashSet<>();
        for (int[] s : stones) {
            roots.add(find(s[0]));
        }
        return stones.length - roots.size();
    }
}
