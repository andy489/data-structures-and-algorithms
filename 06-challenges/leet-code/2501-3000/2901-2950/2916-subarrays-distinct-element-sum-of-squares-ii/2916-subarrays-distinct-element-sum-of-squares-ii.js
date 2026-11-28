// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/

var sumCounts = function(nums) {
    const MOD = 1_000_000_007n;
    const n = nums.length;
    const sumSq = new Array(4 * n).fill(0n);
    const sumD = new Array(4 * n).fill(0n);
    const lazy = new Array(4 * n).fill(0n);
    const cnt = new Array(4 * n).fill(0);

    function build(node, l, r) {
        cnt[node] = r - l + 1;
        if (l === r) return;
        const mid = (l + r) >> 1;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
    }

    function pushDown(node) {
        const lz = lazy[node];
        if (lz === 0n) return;
        for (const child of [2 * node, 2 * node + 1]) {
            const c = BigInt(cnt[child]);
            sumSq[child] = (sumSq[child] + 2n * lz * sumD[child] + lz * lz * c) % MOD;
            sumD[child] = (sumD[child] + lz * c) % MOD;
            lazy[child] = (lazy[child] + lz) % MOD;
        }
        lazy[node] = 0n;
    }

    function update(node, l, r, ql, qr) {
        if (qr < l || r < ql) return;
        if (ql <= l && r <= qr) {
            const c = BigInt(cnt[node]);
            sumSq[node] = (sumSq[node] + 2n * sumD[node] + c) % MOD;
            sumD[node] = (sumD[node] + c) % MOD;
            lazy[node] = (lazy[node] + 1n) % MOD;
            return;
        }
        pushDown(node);
        const mid = (l + r) >> 1;
        update(2 * node, l, mid, ql, qr);
        update(2 * node + 1, mid + 1, r, ql, qr);
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
        sumD[node] = (sumD[2 * node] + sumD[2 * node + 1]) % MOD;
    }

    function query(node, l, r, ql, qr) {
        if (qr < l || r < ql) return 0n;
        if (ql <= l && r <= qr) return sumSq[node];
        pushDown(node);
        const mid = (l + r) >> 1;
        return (query(2 * node, l, mid, ql, qr) + query(2 * node + 1, mid + 1, r, ql, qr)) % MOD;
    }

    build(1, 0, n - 1);
    const lastSeen = new Map();
    let ans = 0n;

    for (let i = 0; i < n; i++) {
        const prev = lastSeen.has(nums[i]) ? lastSeen.get(nums[i]) : -1;
        update(1, 0, n - 1, prev + 1, i);
        ans = (ans + query(1, 0, n - 1, 0, i)) % MOD;
        lastSeen.set(nums[i], i);
    }
    return Number(ans);
};
