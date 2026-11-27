// https://leetcode.com/problems/substring-xor-queries/

// Solution: Precompute Substring Values (up to 32 bits) — O(32n + q) time
class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> firstOccurrence = new HashMap<>();
        int n = s.length();
        for (int l = 0; l < n; l++) {
            if (s.charAt(l) == '0') {
                firstOccurrence.putIfAbsent(0, new int[]{l, l});
                continue;
            }
            int val = 0;
            for (int r = l; r < Math.min(l + 32, n); r++) {
                val = (val << 1) | (s.charAt(r) - '0');
                firstOccurrence.putIfAbsent(val, new int[]{l, r});
            }
        }
        int[][] ans = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i][0] ^ queries[i][1];
            int[] pos = firstOccurrence.get(target);
            ans[i] = pos != null ? pos : new int[]{-1, -1};
        }
        return ans;
    }
}
