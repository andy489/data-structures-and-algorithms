// https://leetcode.com/problems/smallest-string-with-swaps/

// Solution: Union-Find — O(n log n) time, O(n) space
// Solution: Union-Find — O(n log n) time, O(n) space
class Solution {
    int[] parent;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (List<Integer> p : pairs) union(p.get(0), p.get(1));
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) groups.computeIfAbsent(find(i), k -> new ArrayList<>()).add(i);
        char[] res = s.toCharArray();
        for (List<Integer> indices : groups.values()) {
            List<Character> chars = new ArrayList<>();
            for (int idx : indices) chars.add(s.charAt(idx));
            Collections.sort(chars);
            Collections.sort(indices);
            for (int i = 0; i < indices.size(); i++) res[indices.get(i)] = chars.get(i);
        }
        return new String(res);
    }
    int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
    void union(int x, int y) { parent[find(x)] = find(y); }
}
