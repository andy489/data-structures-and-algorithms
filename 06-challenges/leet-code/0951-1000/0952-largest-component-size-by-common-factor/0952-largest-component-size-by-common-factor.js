// https://leetcode.com/problems/largest-component-size-by-common-factor/

var largestComponentSize = function(nums) {
    const max = Math.max(...nums);
    const parent = Array.from({length: max + 1}, (_, i) => i);

    const find = (x) => {
        if (parent[x] !== x) parent[x] = find(parent[x]);
        return parent[x];
    };
    const union = (a, b) => { parent[find(a)] = find(b); };

    for (const n of nums) {
        for (let f = 2; f * f <= n; f++) {
            if (n % f === 0) {
                union(n, f);
                union(n, Math.floor(n / f));
            }
        }
    }
    const count = new Array(max + 1).fill(0);
    let ans = 0;
    for (const n of nums) {
        const root = find(n);
        count[root]++;
        if (count[root] > ans) ans = count[root];
    }
    return ans;
};
