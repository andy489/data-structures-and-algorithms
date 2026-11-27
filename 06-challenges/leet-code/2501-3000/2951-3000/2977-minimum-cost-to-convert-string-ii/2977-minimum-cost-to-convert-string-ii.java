// https://leetcode.com/problems/minimum-cost-to-convert-string-ii/
class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        Map<String, Integer> idMap = new HashMap<>();
        for (String s : original) {
            idMap.putIfAbsent(s, idMap.size());
        }
        for (String s : changed) {
            idMap.putIfAbsent(s, idMap.size());
        }
        int K = idMap.size();
        long INF = Long.MAX_VALUE / 2;
        long[][] dist = new long[K][K];
        for (long[] row : dist) {
            Arrays.fill(row, INF);
        }
        for (int i = 0; i < K; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int from = idMap.get(original[i]);
            int to = idMap.get(changed[i]);
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }
        for (int k = 0; k < K; k++) {
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < K; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int n = source.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) {
                continue;
            }
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }
            for (Map.Entry<String, Integer> entry : idMap.entrySet()) {
                String sub = entry.getKey();
                int len = sub.length();
                if (i + len > n) {
                    continue;
                }
                String srcSub = source.substring(i, i + len);
                if (!srcSub.equals(sub)) {
                    continue;
                }
                String tgtSub = target.substring(i, i + len);
                if (!idMap.containsKey(tgtSub)) {
                    continue;
                }
                int fromId = entry.getValue();
                int toId = idMap.get(tgtSub);
                if (dist[fromId][toId] < INF) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + dist[fromId][toId]);
                }
            }
        }
        return dp[n] == INF ? -1 : dp[n];
    }
}
