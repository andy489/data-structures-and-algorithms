// https://leetcode.com/problems/minimum-cost-good-caption/
/**
 * @param {string} caption
 * @return {string}
 */
var minCostGoodCaption = function(caption) {
    const n = caption.length;
    if (n < 3) {
        return '';
    }

    const INF = Infinity;
    const dp = new Array(n + 1).fill(INF);
    dp[0] = 0;
    const bestGroupSize = new Array(n + 1).fill(0);
    const bestChar = new Array(n + 1).fill('');

    const vals = [...caption].map(c => c.charCodeAt(0) - 97);

    for (let i = 3; i <= n; i++) {
        for (let g = 3; g <= 5 && g <= i; g++) {
            const l = i - g;
            if (dp[l] === INF) {
                continue;
            }
            const group = vals.slice(l, i);
            let bestCost = INF;
            let bestC = '';
            for (let c = 0; c < 26; c++) {
                const cost = group.reduce((s, v) => s + Math.abs(v - c), 0);
                const ch = String.fromCharCode(97 + c);
                if (cost < bestCost || (cost === bestCost && ch < bestC)) {
                    bestCost = cost;
                    bestC = ch;
                }
            }
            const total = dp[l] + bestCost;
            if (total < dp[i] || (total === dp[i] && bestC < bestChar[i])) {
                dp[i] = total;
                bestGroupSize[i] = g;
                bestChar[i] = bestC;
            }
        }
    }

    if (dp[n] === INF) {
        return '';
    }

    const result = new Array(n);
    let pos = n;
    while (pos > 0) {
        const g = bestGroupSize[pos];
        const c = bestChar[pos];
        for (let j = pos - g; j < pos; j++) {
            result[j] = c;
        }
        pos -= g;
    }
    return result.join('');
};
