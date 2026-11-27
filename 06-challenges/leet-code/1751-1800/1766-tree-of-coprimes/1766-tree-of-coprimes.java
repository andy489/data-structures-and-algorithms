// https://leetcode.com/problems/tree-of-coprimes/

// Solution: DFS with Ancestor Tracking by Value — O(n * 50) time, O(n + 50) space
class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // Precompute coprimes for each value 1..50
        List<List<Integer>> coprimes = new ArrayList<>();
        for (int v = 0; v <= 50; v++) {
            List<Integer> cp = new ArrayList<>();
            for (int w = 1; w <= 50; w++) {
                if (gcd(v, w) == 1) cp.add(w);
            }
            coprimes.add(cp);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // last[v] = stack of [nodeId, depth] for ancestors with value v
        List<int[]>[] last = new List[51];
        for (int v = 1; v <= 50; v++) last[v] = new ArrayList<>();

        // Iterative DFS
        int[] parent = new int[n];
        int[] depth = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(parent, -1);
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0}); // node, state (0=enter, 1=leave)
        while (!stack.isEmpty()) {
            int[] cur = stack.peek();
            int u = cur[0], state = cur[1];
            if (state == 0) {
                cur[1] = 1;
                visited[u] = true;
                int d = depth[u];
                // Find closest coprime ancestor
                int bestDepth = -1, bestNode = -1;
                for (int cp : coprimes.get(nums[u])) {
                    List<int[]> stk = last[cp];
                    if (!stk.isEmpty()) {
                        int[] top = stk.get(stk.size() - 1);
                        if (top[1] > bestDepth) {
                            bestDepth = top[1];
                            bestNode = top[0];
                        }
                    }
                }
                ans[u] = bestNode;
                last[nums[u]].add(new int[]{u, d});
                // Push children
                for (int v : graph.get(u)) {
                    if (!visited[v]) {
                        depth[v] = d + 1;
                        stack.push(new int[]{v, 0});
                    }
                }
            } else {
                stack.pop();
                List<int[]> stk = last[nums[u]];
                stk.remove(stk.size() - 1);
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
