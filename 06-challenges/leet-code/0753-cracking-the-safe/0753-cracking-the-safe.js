// https://leetcode.com/problems/cracking-the-safe/

var crackSafe = function(n, k) {
    const visited = new Set();
    const result = [];
    function dfs(node) {
        for (let d = k - 1; d >= 0; d--) {
            const edge = node + d;
            if (!visited.has(edge)) {
                visited.add(edge);
                dfs(node.slice(1) + d);
                result.push(String(d));
            }
        }
    }
    const start = '0'.repeat(n - 1);
    dfs(start);
    return start + result.reverse().join('');
};
