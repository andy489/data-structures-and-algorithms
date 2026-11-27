// https://leetcode.com/problems/smallest-string-with-swaps/

var smallestStringWithSwaps = function(s, pairs) {
    const n = s.length, parent = Array.from({length: n}, (_, i) => i);
    const find = x => parent[x] === x ? x : (parent[x] = find(parent[x]));
    const union = (x, y) => { parent[find(x)] = find(y); };
    for (const [a, b] of pairs) union(a, b);
    const groups = new Map();
    for (let i = 0; i < n; i++) {
        const r = find(i);
        if (!groups.has(r)) groups.set(r, []);
        groups.get(r).push(i);
    }
    const res = s.split('');
    for (const indices of groups.values()) {
        const chars = indices.map(i => s[i]).sort();
        indices.sort((a, b) => a - b);
        indices.forEach((idx, i) => { res[idx] = chars[i]; });
    }
    return res.join('');
};
