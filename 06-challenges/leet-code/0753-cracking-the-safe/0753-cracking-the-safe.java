// https://leetcode.com/problems/cracking-the-safe/

// Solution: De Bruijn Sequence (Hierholzer's) — O(k^n) time, O(k^n) space
class Solution {
    private Set<String> visited;
    private StringBuilder result;
    private int k;

    public String crackSafe(int n, int k) {
        this.k = k;
        visited = new HashSet<>();
        result = new StringBuilder();
        String start = "0".repeat(n);
        dfs(start.substring(1));
        result.append(start.substring(1));
        return start.substring(1) + result.reverse().toString();
    }

    private void dfs(String node) {
        for (int d = k - 1; d >= 0; d--) {
            String edge = node + d;
            if (visited.add(edge)) {
                dfs(node.substring(1) + d);
                result.append(d);
            }
        }
    }
}
