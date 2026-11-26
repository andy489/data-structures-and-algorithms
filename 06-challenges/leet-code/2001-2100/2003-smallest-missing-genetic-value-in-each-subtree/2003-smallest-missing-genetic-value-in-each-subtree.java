// https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree/

// Solution: DFS from Node with Value 1 — O(n) time, O(n) space
class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) { children.add(new ArrayList<>()); }
        for (int i = 1; i < n; i++) { children.get(parents[i]).add(i); }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int start = -1;
        for (int i = 0; i < n; i++) { if (nums[i] == 1) { start = i; break; } }
        if (start == -1) { return ans; }

        Set<Integer> visited = new HashSet<>();
        int mex = 1;
        int cur = start;
        int prev = -1;

        while (cur != -1) {
            dfs(cur, prev, children, nums, visited);
            while (visited.contains(mex)) { mex++; }
            ans[cur] = mex;
            prev = cur;
            cur = parents[cur];
        }
        return ans;
    }

    private void dfs(int node, int skip, List<List<Integer>> children, int[] nums, Set<Integer> visited) {
        visited.add(nums[node]);
        for (int child : children.get(node)) {
            if (child != skip) { dfs(child, -1, children, nums, visited); }
        }
    }
}
