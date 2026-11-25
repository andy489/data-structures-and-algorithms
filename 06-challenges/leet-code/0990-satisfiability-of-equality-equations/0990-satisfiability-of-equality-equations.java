// https://leetcode.com/problems/satisfiability-of-equality-equations/

// Solution: Union-Find — O(n) time, O(1) space
class Solution {
    private int[] parent = new int[26];

    private int find(int x) {
        if (parent[x] != x) { parent[x] = find(parent[x]); }
        return parent[x];
    }

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) { parent[i] = i; }
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                parent[find(eq.charAt(0) - 'a')] = find(eq.charAt(3) - 'a');
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!' && find(eq.charAt(0) - 'a') == find(eq.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }
}
