// https://leetcode.com/problems/properties-graph/

var numberOfComponents = function(properties, k) {
    const n = properties.length;
    const sets = properties.map(row => new Set(row));
    const parent = Array.from({length: n}, (_, i) => i);

    function find(x) {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    function union(a, b) {
        const ra = find(a), rb = find(b);
        if (ra !== rb) {
            parent[ra] = rb;
        }
    }

    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            let count = 0;
            for (const val of sets[i]) {
                if (sets[j].has(val)) {
                    count++;
                }
            }
            if (count >= k) {
                union(i, j);
            }
        }
    }

    return new Set(Array.from({length: n}, (_, i) => find(i))).size;
};
