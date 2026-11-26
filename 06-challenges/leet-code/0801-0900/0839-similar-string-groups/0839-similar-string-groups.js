// https://leetcode.com/problems/similar-string-groups/

var numSimilarGroups = function(strs) {
    const n = strs.length, parent = Array.from({length: n}, (_, i) => i);
    function find(x) {
        while (parent[x] !== x) { parent[x] = parent[parent[x]]; x = parent[x]; }
        return x;
    }
    function similar(a, b) {
        let d = 0;
        for (let i = 0; i < a.length; i++) { if (a[i] !== b[i] && ++d > 2) { return false; } }
        return d === 0 || d === 2;
    }
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            if (similar(strs[i], strs[j])) { parent[find(i)] = find(j); }
        }
    }
    return strs.filter((_, i) => find(i) === i).length;
};
