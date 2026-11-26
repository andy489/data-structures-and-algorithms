// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

// Solution: DFS Post-order with Frequency Arrays — O(n * 26) time, O(n * 26) space
class Solution {
    private List<Integer>[] adj;
    private int[] ans;
    private String labels;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        ans = new int[n];
        this.labels = labels;
        dfs(0, -1);
        return ans;
    }

    private int[] dfs(int node, int parent) {
        int[] freq = new int[26];
        freq[labels.charAt(node) - 'a']++;
        for (int child : adj[node]) {
            if (child == parent) {
                continue;
            }
            int[] childFreq = dfs(child, node);
            for (int i = 0; i < 26; i++) {
                freq[i] += childFreq[i];
            }
        }
        ans[node] = freq[labels.charAt(node) - 'a'];
        return freq;
    }
}
