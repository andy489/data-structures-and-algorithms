// https://leetcode.com/problems/regular-expression-matching/

var isMatch = function(s, p) {
    const n = s.length;
    const m = p.length;
    const cache = new Map();

    function dfs(i, j) {
        if (j >= m) {
            return i >= n;
        }
        const key = `${i},${j}`;
        if (cache.has(key)) {
            return cache.get(key);
        }
        const matched = i < n && (s[i] === p[j] || p[j] === '.');
        let result;
        if (j + 1 < m && p[j + 1] === '*') {
            result = dfs(i, j + 2) || (matched && dfs(i + 1, j));
        } else {
            result = matched && dfs(i + 1, j + 1);
        }
        cache.set(key, result);
        return result;
    }

    return dfs(0, 0);
};
