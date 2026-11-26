// https://leetcode.com/problems/number-of-provinces/
// Solution: Union-Find — O(n^2 · α(n)) time, O(n) space
var findCircleNum = function(isConnected) {
    const n = isConnected.length;
    const parent = Array.from({length: n}, (_, i) => i);
    function find(x) {
        if (parent[x] !== x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    function union(a, b) {
        parent[find(a)] = find(b);
    }
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            if (isConnected[i][j] === 1) {
                union(i, j);
            }
        }
    }
    return parent.filter((_, i) => find(i) === i).length;
};
