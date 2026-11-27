// https://leetcode.com/problems/handling-sum-queries-after-update/

// Solution: Segment Tree with Lazy Propagation — O((n+q) log n) time
var handleQuery = function(nums1, nums2, queries) {
    const n = nums1.length;
    const tree = new Int32Array(4 * n);
    const lazy = new Uint8Array(4 * n);

    function build(node, l, r) {
        if (l === r) {
            tree[node] = nums1[l];
            return;
        }
        const mid = (l + r) >> 1;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    function pushDown(node, l, r) {
        if (lazy[node]) {
            const mid = (l + r) >> 1;
            tree[2 * node] = (mid - l + 1) - tree[2 * node];
            tree[2 * node + 1] = (r - mid) - tree[2 * node + 1];
            lazy[2 * node] ^= 1;
            lazy[2 * node + 1] ^= 1;
            lazy[node] = 0;
        }
    }

    function flip(node, l, r, ql, qr) {
        if (ql <= l && r <= qr) {
            tree[node] = (r - l + 1) - tree[node];
            lazy[node] ^= 1;
            return;
        }
        pushDown(node, l, r);
        const mid = (l + r) >> 1;
        if (ql <= mid) {
            flip(2 * node, l, mid, ql, qr);
        }
        if (qr > mid) {
            flip(2 * node + 1, mid + 1, r, ql, qr);
        }
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    build(1, 0, n - 1);
    let sum2 = nums2.reduce((a, b) => a + b, 0);
    const result = [];
    for (const [type, a, b] of queries) {
        if (type === 1) {
            flip(1, 0, n - 1, a, b);
        } else if (type === 2) {
            sum2 += tree[1] * a;
        } else {
            result.push(sum2);
        }
    }
    return result;
};
