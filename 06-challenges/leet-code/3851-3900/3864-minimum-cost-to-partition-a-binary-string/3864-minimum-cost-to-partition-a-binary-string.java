// https://leetcode.com/problems/minimum-cost-to-partition-a-binary-string/

class Solution {
    private int[] prefix;
    private String s;
    private int encCost, flatCost;
    private Map<Long, Long> memo = new HashMap<>();

    private long solve(int l, int r) {
        int len = r - l + 1;
        int ones = prefix[r + 1] - prefix[l];
        long cost = (ones == 0) ? flatCost : (long) len * ones * encCost;
        if (len % 2 != 0) {
            return cost;
        }
        long key = (long) l * 100001 + r;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int mid = (l + r) / 2;
        long split = solve(l, mid) + solve(mid + 1, r);
        long result = Math.min(cost, split);
        memo.put(key, result);
        return result;
    }

    public long minimumCost(String s, int encCost, int flatCost) {
        this.s = s;
        this.encCost = encCost;
        this.flatCost = flatCost;
        int n = s.length();
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) - '0');
        }
        return solve(0, n - 1);
    }
}
