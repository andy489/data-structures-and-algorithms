// https://leetcode.com/problems/process-restricted-friend-requests/

// Solution: Union-Find — O(r*q) time, O(n) space
var friendRequests = function(n, restrictions, requests) {
    const parent = Array.from({length: n}, (_, i) => i);
    const find = (x) => { while (parent[x] !== x) { parent[x] = parent[parent[x]]; x = parent[x]; } return x; };
    const union = (a, b) => { parent[find(a)] = find(b); };
    return requests.map(([u, v]) => {
        const ru = find(u), rv = find(v);
        if (ru === rv) return true;
        const ok = restrictions.every(([x, y]) => {
            const rx = find(x), ry = find(y);
            return !((rx === ru && ry === rv) || (rx === rv && ry === ru));
        });
        if (ok) union(ru, rv);
        return ok;
    });
};
