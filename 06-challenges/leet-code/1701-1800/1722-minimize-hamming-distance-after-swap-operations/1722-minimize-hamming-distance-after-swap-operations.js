// https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/

var minimumHammingDistance = function(source, target, allowedSwaps) {
    const n = source.length;
    const parent = Array.from({length: n}, (_, i) => i);

    const find = (x) => {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    };

    for (const [a, b] of allowedSwaps) {
        const ra = find(a), rb = find(b);
        if (ra !== rb) {
            parent[ra] = rb;
        }
    }

    const groups = new Map();
    for (let i = 0; i < n; i++) {
        const root = find(i);
        if (!groups.has(root)) {
            groups.set(root, []);
        }
        groups.get(root).push(i);
    }

    let dist = 0;
    for (const indices of groups.values()) {
        const freq = new Map();
        for (const idx of indices) {
            freq.set(source[idx], (freq.get(source[idx]) || 0) + 1);
        }
        for (const idx of indices) {
            const t = target[idx];
            if ((freq.get(t) || 0) > 0) {
                freq.set(t, freq.get(t) - 1);
            } else {
                dist++;
            }
        }
    }
    return dist;
};
