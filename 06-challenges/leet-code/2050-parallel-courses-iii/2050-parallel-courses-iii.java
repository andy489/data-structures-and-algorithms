// https://leetcode.com/problems/parallel-courses-iii/

// Solution: Topological Sort DP — O(V+E) time, O(V+E) space
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> next = new ArrayList<>();
        int[] inDeg = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) { next.add(new ArrayList<>()); }
        for (int[] r : relations) { next.get(r[0]).add(r[1]); inDeg[r[1]]++; }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) { if (inDeg[i] == 0) { q.offer(i); dp[i] = time[i - 1]; } }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : next.get(u)) {
                dp[v] = Math.max(dp[v], dp[u] + time[v - 1]);
                if (--inDeg[v] == 0) { q.offer(v); }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) { res = Math.max(res, dp[i]); }
        return res;
    }
}
