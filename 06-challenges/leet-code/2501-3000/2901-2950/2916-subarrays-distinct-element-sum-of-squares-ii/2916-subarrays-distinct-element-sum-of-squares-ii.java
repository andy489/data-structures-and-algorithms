// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/

// Solution: Segment Tree with Lazy Propagation — O(n log n) time, O(n) space
class Solution {
    static final int MOD = 1_000_000_007;
    long[] sumSq, sumD, lazy;
    int[] cnt; // cnt[node] = number of leaves in this node's range

    void build(int node, int l, int r) {
        sumSq[node] = sumD[node] = lazy[node] = 0;
        cnt[node] = r - l + 1;
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
    }

    void pushDown(int node) {
        if (lazy[node] == 0) {
            return;
        }
        long lz = lazy[node];
        for (int child : new int[]{2 * node, 2 * node + 1}) {
            int c = cnt[child];
            // (d + lz)^2 = d^2 + 2*lz*d + lz^2
            sumSq[child] = (sumSq[child] + 2 * lz % MOD * sumD[child] % MOD + lz * lz % MOD * c % MOD) % MOD;
            sumD[child] = (sumD[child] + lz * c % MOD) % MOD;
            lazy[child] = (lazy[child] + lz) % MOD;
        }
        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) {
            return;
        }
        if (ql <= l && r <= qr) {
            int c = cnt[node];
            sumSq[node] = (sumSq[node] + 2 * sumD[node] % MOD + c) % MOD;
            sumD[node] = (sumD[node] + c) % MOD;
            lazy[node]++;
            return;
        }
        pushDown(node);
        int mid = (l + r) / 2;
        update(2 * node, l, mid, ql, qr);
        update(2 * node + 1, mid + 1, r, ql, qr);
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
        sumD[node] = (sumD[2 * node] + sumD[2 * node + 1]) % MOD;
    }

    long query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) {
            return 0;
        }
        if (ql <= l && r <= qr) {
            return sumSq[node];
        }
        pushDown(node);
        int mid = (l + r) / 2;
        return (query(2 * node, l, mid, ql, qr) + query(2 * node + 1, mid + 1, r, ql, qr)) % MOD;
    }

    public long sumCounts(int[] nums) {
        int n = nums.length;
        sumSq = new long[4 * n];
        sumD = new long[4 * n];
        lazy = new long[4 * n];
        cnt = new int[4 * n];
        build(1, 0, n - 1);

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = lastSeen.getOrDefault(nums[i], -1);
            update(1, 0, n - 1, prev + 1, i);
            ans = (ans + query(1, 0, n - 1, 0, i)) % MOD;
            lastSeen.put(nums[i], i);
        }
        return ans;
    }
}
