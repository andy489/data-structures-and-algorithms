// https://leetcode.com/problems/flower-planting-with-no-adjacent/

// Solution: Greedy Graph Coloring — O(n + E) time, O(n + E) space
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : paths) {
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Set<Integer> used = new HashSet<>();
            for (int nb : adj.get(i)) {
                used.add(ans[nb]);
            }
            for (int c = 1; c <= 4; c++) {
                if (!used.contains(c)) {
                    ans[i] = c;
                    break;
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ans[i + 1];
        }
        return res;
    }
}
