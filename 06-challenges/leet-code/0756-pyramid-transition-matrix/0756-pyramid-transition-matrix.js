// https://leetcode.com/problems/pyramid-transition-matrix/

var pyramidTransition = function(bottom, allowed) {
    const rules = new Map();
    for (const s of allowed) {
        const key = s.slice(0, 2);
        if (!rules.has(key)) rules.set(key, []);
        rules.get(key).push(s[2]);
    }
    const memo = new Set();
    function dfs(cur, next) {
        if (cur.length === 1) return true;
        if (next.length + 1 === cur.length) {
            return dfs(next, '');
        }
        const idx = next.length;
        const opts = rules.get(cur.slice(idx, idx + 2)) || [];
        for (const c of opts) {
            const nxt = next + c;
            const key = cur + '#' + nxt;
            if (!memo.has(key)) {
                if (dfs(cur, nxt)) return true;
                memo.add(key);
            }
        }
        return false;
    }
    return dfs(bottom, '');
};
