// https://leetcode.com/problems/longest-special-path-ii/

// Solution: DFS with Two-Pointer on Path — O(n log n) time, O(n) space
class Solution {
    private List<int[]>[] adj;
    private int[] nums;
    private long bestLen = 0;
    private int bestNodes = 1;
    // For each value, track last two depths (positions in path)
    private int[] last1, last2;
    private long[] prefixLen;
    private int pathSize;

    @SuppressWarnings("unchecked")
    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        int n = nums.length;
        this.nums = nums;
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }
        last1 = new int[50001];
        last2 = new int[50001];
        Arrays.fill(last1, -1);
        Arrays.fill(last2, -1);
        prefixLen = new long[n + 1];
        pathSize = 0;
        dfs(0, -1, 0, 0);
        return new int[]{(int) bestLen, bestNodes};
    }

    private void dfs(int node, int parent, int depth, int start) {
        int v = nums[node];
        int prevL1 = last1[v], prevL2 = last2[v];
        // Update last occurrences
        last2[v] = last1[v];
        last1[v] = depth;
        // The new start is max(start, last2[v] + 1) if last2[v] != -1
        int newStart = start;
        if (prevL2 != -1) {
            newStart = Math.max(newStart, prevL2 + 1);
        }
        // Length of path from newStart to current depth
        long pathLen = prefixLen[depth + 1] - prefixLen[newStart];
        int nodeCount = depth - newStart + 1;
        if (pathLen > bestLen || (pathLen == bestLen && nodeCount < bestNodes)) {
            bestLen = pathLen;
            bestNodes = nodeCount;
        }
        for (int[] next : adj[node]) {
            if (next[0] != parent) {
                prefixLen[depth + 2] = prefixLen[depth + 1] + next[1];
                dfs(next[0], node, depth + 1, newStart);
            }
        }
        // Restore
        last1[v] = prevL1;
        last2[v] = prevL2;
    }
}
