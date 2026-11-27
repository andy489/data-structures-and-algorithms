// https://leetcode.com/problems/frequencies-of-shortest-supersequences/
/**
 * @param {string[]} words
 * @return {number[][]}
 */
var supersequences = function(words) {
    const charIdx = {};
    for (const w of words) {
        for (const c of w) {
            if (!(c in charIdx)) {
                charIdx[c] = Object.keys(charIdx).length;
            }
        }
    }
    const m = Object.keys(charIdx).length;

    const minCount = new Array(m).fill(1);
    const hasEdge = Array.from({length: m}, () => new Array(m).fill(false));

    for (const w of words) {
        const a = charIdx[w[0]];
        const b = charIdx[w[1]];
        if (a === b) {
            minCount[a] = Math.max(minCount[a], 2);
        } else {
            hasEdge[a][b] = true;
        }
    }

    const full = 1 << m;
    const dp = new Array(full).fill(Infinity);
    dp[0] = 0;

    for (let mask = 0; mask < full; mask++) {
        if (dp[mask] === Infinity) {
            continue;
        }
        for (let i = 0; i < m; i++) {
            if (mask & (1 << i)) {
                continue;
            }
            let extra = 0;
            for (let j = 0; j < m; j++) {
                if ((mask & (1 << j)) && hasEdge[i][j]) {
                    extra++;
                }
            }
            const newMask = mask | (1 << i);
            if (dp[mask] + extra < dp[newMask]) {
                dp[newMask] = dp[mask] + extra;
            }
        }
    }

    const minExtra = dp[full - 1];
    const resultSet = new Set();
    const extraCount = new Array(m).fill(0);

    function dfs(pos, mask) {
        if (pos === m) {
            const freq = new Array(26).fill(0);
            for (const [c, idx] of Object.entries(charIdx)) {
                freq[c.charCodeAt(0) - 97] = minCount[idx] + extraCount[idx];
            }
            resultSet.add(freq.join(','));
            return;
        }
        for (let i = 0; i < m; i++) {
            if (mask & (1 << i)) {
                continue;
            }
            let extra = 0;
            for (let j = 0; j < m; j++) {
                if ((mask & (1 << j)) && hasEdge[i][j]) {
                    extra++;
                }
            }
            const newMask = mask | (1 << i);
            if (dp[mask] + extra <= minExtra && dp[newMask] === dp[mask] + extra) {
                extraCount[i] += extra;
                dfs(pos + 1, newMask);
                extraCount[i] -= extra;
            }
        }
    }

    dfs(0, 0);
    return Array.from(resultSet).map(s => s.split(',').map(Number));
};
