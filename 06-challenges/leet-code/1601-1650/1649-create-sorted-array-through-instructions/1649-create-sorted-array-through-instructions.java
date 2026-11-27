// https://leetcode.com/problems/create-sorted-array-through-instructions/

// Solution: Binary Indexed Tree (Fenwick Tree) — O(n log M) time, O(M) space
class Solution {
    private int[] bit;

    private void update(int i) {
        for (; i < bit.length; i += i & -i) {
            bit[i]++;
        }
    }

    private int query(int i) {
        int s = 0;
        for (; i > 0; i -= i & -i) {
            s += bit[i];
        }
        return s;
    }

    public int createSortedArray(int[] instructions) {
        final int MOD = 1_000_000_007;
        final int MAX = 100_001;
        bit = new int[MAX + 1];
        long cost = 0;
        for (int i = 0; i < instructions.length; i++) {
            int v = instructions[i];
            int less = query(v - 1);
            int greater = i - query(v);
            cost += Math.min(less, greater);
            update(v);
        }
        return (int) (cost % MOD);
    }
}
