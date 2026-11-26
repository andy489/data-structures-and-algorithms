// https://leetcode.com/problems/count-pairs-of-nodes/

// Solution: Sorted Degrees + Two Pointers + Prefix Sums — O((n + m + q) log n) time, O(n + m) space
class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] deg = new int[n + 1];
        Map<Long, Integer> shared = new HashMap<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            deg[u]++;
            deg[v]++;
            long key = Math.min(u, v) * 20001L + Math.max(u, v);
            shared.merge(key, 1, Integer::sum);
        }

        int[] sorted = Arrays.copyOfRange(deg, 1, n + 1);
        Arrays.sort(sorted);

        int[] ans = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            int threshold = queries[qi];
            int count = 0;
            int lo = 0, hi = n - 1;
            while (lo < hi) {
                if (sorted[lo] + sorted[hi] > threshold) {
                    count += hi - lo;
                    hi--;
                } else {
                    lo++;
                }
            }
            for (Map.Entry<Long, Integer> entry : shared.entrySet()) {
                long key = entry.getKey();
                int u = (int) (key / 20001);
                int v = (int) (key % 20001);
                int cnt = entry.getValue();
                if (deg[u] + deg[v] > threshold && deg[u] + deg[v] - cnt <= threshold) {
                    count--;
                }
            }
            ans[qi] = count;
        }
        return ans;
    }
}
