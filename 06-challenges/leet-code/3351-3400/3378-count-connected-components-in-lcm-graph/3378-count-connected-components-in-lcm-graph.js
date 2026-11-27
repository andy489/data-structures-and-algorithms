// https://leetcode.com/problems/count-connected-components-in-lcm-graph/

var countComponents = function(nums, threshold) {
    const parent = Array.from({length: threshold + 1}, (_, i) => i);
    const rank = new Array(threshold + 1).fill(0);

    const find = (x) => {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    };

    const union = (a, b) => {
        let ra = find(a), rb = find(b);
        if (ra === rb) return;
        if (rank[ra] < rank[rb]) { [ra, rb] = [rb, ra]; }
        parent[rb] = ra;
        if (rank[ra] === rank[rb]) rank[ra]++;
    };

    const present = new Set();
    let isolated = 0;
    for (const x of nums) {
        if (x > threshold) {
            isolated++;
        } else {
            present.add(x);
        }
    }

    for (let d = 1; d <= threshold; d++) {
        let first = -1;
        for (let multiple = d; multiple <= threshold; multiple += d) {
            if (present.has(multiple)) {
                if (first === -1) {
                    first = multiple;
                } else {
                    union(first, multiple);
                }
            }
        }
    }

    const roots = new Set();
    for (const x of nums) {
        if (x <= threshold) {
            roots.add(find(x));
        }
    }
    return roots.size + isolated;
};
