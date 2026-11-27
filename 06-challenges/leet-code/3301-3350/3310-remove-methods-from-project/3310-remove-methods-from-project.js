// https://leetcode.com/problems/remove-methods-from-project/

/**
 * @param {number} n
 * @param {number} k
 * @param {number[][]} invocations
 * @return {number[]}
 */
var remainingMethods = function (n, k, invocations) {
    const adj = Array.from({ length: n }, () => []);
    for (const [a, b] of invocations) {
        adj[a].push(b);
    }
    const suspicious = new Array(n).fill(false);
    const queue = [k];
    suspicious[k] = true;
    while (queue.length > 0) {
        const cur = queue.shift();
        for (const nxt of adj[cur]) {
            if (!suspicious[nxt]) {
                suspicious[nxt] = true;
                queue.push(nxt);
            }
        }
    }
    for (const [a, b] of invocations) {
        if (!suspicious[a] && suspicious[b]) {
            return Array.from({ length: n }, (_, i) => i);
        }
    }
    const result = [];
    for (let i = 0; i < n; i++) {
        if (!suspicious[i]) {
            result.push(i);
        }
    }
    return result;
};
