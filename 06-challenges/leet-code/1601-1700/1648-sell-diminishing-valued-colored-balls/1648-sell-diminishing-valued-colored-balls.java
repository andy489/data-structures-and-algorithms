// https://leetcode.com/problems/sell-diminishing-valued-colored-balls/

// Solution: Greedy with Sorted Levels — O(n log n) time, O(1) space
class Solution {
    public int maxProfit(int[] inventory, int orders) {
        final long MOD = 1_000_000_007L;
        Arrays.sort(inventory);
        int n = inventory.length;
        long ans = 0;
        long count = 1;
        for (int i = n - 1; i >= 0; i--) {
            long cur = inventory[i];
            long next = (i > 0) ? inventory[i - 1] : 0;
            long diff = cur - next;
            long balls = diff * count;
            if (orders >= balls) {
                // sell all in this layer
                // sum from (next+1) to cur, count times each
                ans = (ans + count % MOD * sumRange(next + 1, cur) % MOD) % MOD;
                orders -= balls;
            } else {
                // partial: sell 'orders' balls from the top
                long full = orders / count;
                long rem = orders % count;
                // full layers from cur down to (cur - full + 1)
                ans = (ans + count % MOD * sumRange(cur - full + 1, cur) % MOD) % MOD;
                // rem balls at value (cur - full)
                ans = (ans + rem % MOD * ((cur - full) % MOD) % MOD) % MOD;
                orders = 0;
                break;
            }
            count++;
        }
        return (int) (ans % MOD);
    }

    private long sumRange(long lo, long hi) {
        final long MOD = 1_000_000_007L;
        // sum lo + (lo+1) + ... + hi = (hi - lo + 1) * (lo + hi) / 2
        long len = (hi - lo + 1) % MOD;
        long s = (lo % MOD + hi % MOD) % MOD;
        return len * s % MOD * 500_000_004L % MOD; // 500_000_004 is modular inverse of 2
    }
}
