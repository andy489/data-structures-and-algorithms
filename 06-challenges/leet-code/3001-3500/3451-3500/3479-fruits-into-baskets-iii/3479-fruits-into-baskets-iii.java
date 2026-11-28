// https://leetcode.com/problems/fruits-into-baskets-iii/

// Solution: Segment Tree — O(n log n) time, O(n) space
class Solution {
    private int[] tree;
    private int n;

    private void build(int[] baskets, int node, int lo, int hi) {
        if (lo == hi) {
            tree[node] = baskets[lo];
            return;
        }
        int mid = (lo + hi) / 2;
        build(baskets, 2 * node, lo, mid);
        build(baskets, 2 * node + 1, mid + 1, hi);
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    private int query(int node, int lo, int hi, int need) {
        if (lo == hi) {
            return lo;
        }
        int mid = (lo + hi) / 2;
        if (tree[2 * node] >= need) {
            return query(2 * node, lo, mid, need);
        }
        return query(2 * node + 1, mid + 1, hi, need);
    }

    private void update(int node, int lo, int hi, int pos) {
        if (lo == hi) {
            tree[node] = 0;
            return;
        }
        int mid = (lo + hi) / 2;
        if (pos <= mid) {
            update(2 * node, lo, mid, pos);
        } else {
            update(2 * node + 1, mid + 1, hi, pos);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        tree = new int[4 * n];
        build(baskets, 1, 0, n - 1);
        int unplaced = 0;
        for (int f : fruits) {
            if (tree[1] < f) {
                unplaced++;
            } else {
                int idx = query(1, 0, n - 1, f);
                update(1, 0, n - 1, idx);
            }
        }
        return unplaced;
    }
}
