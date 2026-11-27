// https://leetcode.com/problems/longest-path-with-different-adjacent-characters/

class Solution {
    private List<Integer>[] children;
    private String s;
    private int ans;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.ans = 1;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
        dfs(0);
        return ans;
    }

    private int dfs(int node) {
        int top1 = 0, top2 = 0;
        for (int child : children[node]) {
            int len = dfs(child);
            if (s.charAt(child) == s.charAt(node)) {
                continue;
            }
            if (len > top1) {
                top2 = top1;
                top1 = len;
            } else if (len > top2) {
                top2 = len;
            }
        }
        ans = Math.max(ans, top1 + top2 + 1);
        return top1 + 1;
    }
}
