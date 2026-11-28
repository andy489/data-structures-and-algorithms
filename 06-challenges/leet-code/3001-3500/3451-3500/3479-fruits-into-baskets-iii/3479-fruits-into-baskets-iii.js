// https://leetcode.com/problems/fruits-into-baskets-iii/

var numOfUnplacedFruits = function(fruits, baskets) {
    const n = baskets.length;
    const tree = new Array(4 * n).fill(0);

    const build = (node, lo, hi) => {
        if (lo === hi) { tree[node] = baskets[lo]; return; }
        const mid = (lo + hi) >> 1;
        build(2 * node, lo, mid);
        build(2 * node + 1, mid + 1, hi);
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    };

    const query = (node, lo, hi, need) => {
        if (lo === hi) return lo;
        const mid = (lo + hi) >> 1;
        if (tree[2 * node] >= need) return query(2 * node, lo, mid, need);
        return query(2 * node + 1, mid + 1, hi, need);
    };

    const update = (node, lo, hi, pos) => {
        if (lo === hi) { tree[node] = 0; return; }
        const mid = (lo + hi) >> 1;
        if (pos <= mid) update(2 * node, lo, mid, pos);
        else update(2 * node + 1, mid + 1, hi, pos);
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    };

    build(1, 0, n - 1);
    let unplaced = 0;
    for (const f of fruits) {
        if (tree[1] < f) {
            unplaced++;
        } else {
            const idx = query(1, 0, n - 1, f);
            update(1, 0, n - 1, idx);
        }
    }
    return unplaced;
};
