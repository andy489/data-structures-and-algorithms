// https://leetcode.com/problems/count-connected-subgraphs-with-even-node-sum/
class Solution {
    public int countSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        int[] adj = new int[n];
        for (int[] e : edges) {
            adj[e[0]] |= (1 << e[1]);
            adj[e[1]] |= (1 << e[0]);
        }
        int count = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                }
            }
            if (sum % 2 != 0) {
                continue;
            }
            if (isConnected(mask, adj, n)) {
                count++;
            }
        }
        return count;
    }

    private boolean isConnected(int mask, int[] adj, int n) {
        int start = Integer.numberOfTrailingZeros(mask);
        int visited = 0;
        int queue = (1 << start);
        visited = queue;
        while (queue != 0) {
            int node = Integer.numberOfTrailingZeros(queue);
            queue &= ~(1 << node);
            int neighbors = adj[node] & mask & ~visited;
            visited |= neighbors;
            queue |= neighbors;
        }
        return visited == mask;
    }
}
