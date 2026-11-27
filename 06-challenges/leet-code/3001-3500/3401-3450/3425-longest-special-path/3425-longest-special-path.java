// https://leetcode.com/problems/longest-special-path/

class Solution {
    private int[] nums;
    private List<int[]>[] adj;
    private int bestLen;
    private int bestNodes;

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
        bestLen = 0;
        bestNodes = 1;
        // prefixDist[d] = total edge length from root to node at depth d on current path
        long[] prefixDist = new long[n + 1];
        // lastDepth[v] = depth at which value v last appeared on current path (-1 if not)
        int[] lastDepth = new int[50001];
        Arrays.fill(lastDepth, -1);
        dfs(0, -1, 0, 0, prefixDist, lastDepth);
        return new int[]{bestLen, bestNodes};
    }

    private void dfs(int node, int parent, int depth, int startDepth,
                     long[] prefixDist, int[] lastDepth) {
        int val = nums[node];
        int prevDepth = lastDepth[val];
        // Start of path must be after prevDepth to keep values unique
        int newStart = Math.max(startDepth, prevDepth + 1);
        // Update best: path from newStart to depth
        // Length = prefixDist[depth] - prefixDist[newStart]
        // But prefixDist[depth] = prefixDist[depth-1] + edge weight (set by parent)
        // prefixDist[depth] was already set before this call
        long pathLength = prefixDist[depth] - prefixDist[newStart];
        int nodeCount = depth - newStart + 1;
        if (pathLength > bestLen || (pathLength == bestLen && nodeCount < bestNodes)) {
            bestLen = (int) pathLength;
            bestNodes = nodeCount;
        }
        lastDepth[val] = depth;
        for (int[] nb : adj[node]) {
            if (nb[0] != parent) {
                prefixDist[depth + 1] = prefixDist[depth] + nb[1];
                dfs(nb[0], node, depth + 1, newStart, prefixDist, lastDepth);
            }
        }
        lastDepth[val] = prevDepth;
    }
}
